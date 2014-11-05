package org.sonatype.mavenbook.utils.interceptor;

/** 
 * 分页用拦截器 
 */
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathNotFoundException;
import org.apache.ibatis.executor.Executor;
//import org.apache.ibatis.executor.parameter.DefaultParameterHandler;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.sonatype.mavenbook.utils.Page;
import org.sonatype.mavenbook.utils.ReflectHelper;
import org.sonatype.mavenbook.utils.serlvet.PageContext;

/*
iBatis plugin/mybatis 拦截器好像只能使用注解，而且对于接口Executor，method只定义了update，query，flushStatements，commit，rollback
，createCacheKey，isCached，clearLocalCache，deferLoad，getTransaction，close，isClosed这几个方法，没有delete和insert方法。
原来在DefaultSqlSession的insert，delete方法是调用了update方法。
*/
@Intercepts({ @Signature(type = Executor.class, method = "query", args = {
		MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) })
public class PageInterceptor implements Interceptor {

	public Object intercept(Invocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName(); //被拦截的方法名

		// 当前环境 MappedStatement，BoundSql，及sql取得
		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		Object parameter = invocation.getArgs()[1];
		BoundSql boundSql = mappedStatement.getBoundSql(parameter);
		String originalSql = boundSql.getSql().trim();
		Object parameterObject = boundSql.getParameterObject();
		
		/* wu 
		使用ThreadLocal类封装Page对象，让Service层等无需传Page对象，减小了侵入性。
		拦截器也省去了查找Page对象的动作，性能也同时改善。
		*/
		
		// Page对象获取，“信使”到达拦截器！
		//Page page_xpath = searchPageWithXpath(boundSql.getParameterObject(), ".","page", "*/page");
		/*********************************************************/
		Page page = PageContext.getPage();  //aaa!!!
		/*
        if (parameterObject instanceof Page) {
            page = (Page) parameterObject;
            //page.setTotalResult(count);
        } else if(parameterObject instanceof Map){
            Map<String, Object> map = (Map<String, Object>)parameterObject;
            page = (Page)map.get("pager");
            if(page == null){
                //page = new Page();
            	//page = Page.newBuilder(1, 2, "/list");
            	System.out.print("no pager obj!");
            	//map.put("page", page); //
            }
            //page.setTotalResult(count);
        }else {
            Field pageField = ReflectHelper.getFieldByFieldName(parameterObject, "pager");
            if (pageField != null) {
                page = (Page) ReflectHelper.getValueByFieldName(parameterObject, "pager");
                if (page == null){
                    //page = new Page();
                	System.out.print("no pager obj!");
                }
                //page.setTotalResult(count);
                ReflectHelper.setValueByFieldName(parameterObject, "pager", page);
            } else {
                //throw new NoSuchFieldException(parameterObject.getClass().getName());
                System.out.print("no pager obj!");
            }
        }*/
		/*********************************************************/
		
		if (page != null) {
			// Page对象存在的场合，开始分页处理
			String countSql = getCountSql(originalSql);
			Connection connection = mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
			PreparedStatement countStmt = connection.prepareStatement(countSql);
			BoundSql countBS = copyFromBoundSql(mappedStatement, boundSql, countSql);
			DefaultParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, countBS);
			parameterHandler.setParameters(countStmt);
			ResultSet rs = countStmt.executeQuery();
			int totpage = 0;
			if (rs.next()) {
				totpage = rs.getInt(1);
			}
			rs.close();
			countStmt.close();
			connection.close();

			// 分页计算
			page.setTotalRecord(totpage);

			// 对原始Sql追加limit: wu 适用mysql
			int offset = (page.getPageNo() - 1) * page.getPageSize();
			StringBuffer sb = new StringBuffer();
			sb.append(originalSql).append(" limit ").append(offset).append(",").append(page.getPageSize());
			BoundSql newBoundSql = copyFromBoundSql(mappedStatement, boundSql, sb.toString());
			MappedStatement newMs = copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(newBoundSql));
			invocation.getArgs()[0] = newMs; //sql mappedStatement: getArgs()[0] 
		}
		return invocation.proceed();

	}

	/**
	 * 根据给定的xpath查询Page对象
	 */
	private Page searchPageWithXpath(Object o, String... xpaths) {
		JXPathContext context = JXPathContext.newContext(o);
		Object result;
		for (String xpath : xpaths) {
			try {
				result = context.selectSingleNode(xpath);
			} catch (JXPathNotFoundException e) {
				continue;
			}
			if (result instanceof Page) {
				return (Page) result;
			}
		}
		return null;
	}

	/**
	 * 复制MappedStatement对象
	 */
	private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
		Builder builder = new Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());

		builder.resource(ms.getResource());
		builder.fetchSize(ms.getFetchSize());
		builder.statementType(ms.getStatementType());
		builder.keyGenerator(ms.getKeyGenerator());
		//builder.keyProperty(ms.getKeyProperty());
		//:wu
		builder.keyProperty(ms.getId()); //sqlId 
		//builder.keyProperty(ms.getKeyProperties()); //???
		
		builder.timeout(ms.getTimeout());
		builder.parameterMap(ms.getParameterMap());
		builder.resultMaps(ms.getResultMaps());
		builder.resultSetType(ms.getResultSetType());
		builder.cache(ms.getCache());
		builder.flushCacheRequired(ms.isFlushCacheRequired());
		builder.useCache(ms.isUseCache());

		return builder.build();
	}

	/**
	 * 复制BoundSql对象
	 */
	private BoundSql copyFromBoundSql(MappedStatement ms, BoundSql boundSql, String sql) {
		BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql,	boundSql.getParameterMappings(), boundSql.getParameterObject());
		for (ParameterMapping mapping : boundSql.getParameterMappings()) {
			String prop = mapping.getProperty();
			if (boundSql.hasAdditionalParameter(prop)) {
				newBoundSql.setAdditionalParameter(prop, boundSql.getAdditionalParameter(prop));
			}
		}
		return newBoundSql;
	}

	/**
	 * 根据原Sql语句获取对应的查询总记录数的Sql语句
	 */
	private String getCountSql(String sql) {
		return "SELECT COUNT(*) FROM (" + sql + ") aliasForPage";
	}

	public class BoundSqlSqlSource implements SqlSource {
		BoundSql boundSql;

		public BoundSqlSqlSource(BoundSql boundSql) {
			this.boundSql = boundSql;
		}

		public BoundSql getBoundSql(Object parameterObject) {
			return boundSql;
		}
	}

	public Object plugin(Object arg0) {
		return Plugin.wrap(arg0, this);
	}

	public void setProperties(Properties arg0) {
		//this.properties = arg0;
		//this.properties = properties;
	}
}
