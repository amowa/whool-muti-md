package org.sonatype.mavenbook.utils.serlvet;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sonatype.mavenbook.utils.Page;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
/*
将位于Control类中 侵入性的分页相关代码: model.addAttribute("pager", page) 移入过滤器。
发现当前的 Url  在配置文件中有匹配是就构造Page对象，并加入到Response中。
继承 DispatcherSerlvet，覆写 render方法，在渲染之前吧 Page 放入ModelAndView里面。
（DispatcherSerlvet变了，要修改Servlet配置）
*/
public class MyDispatcherSerlvet extends DispatcherServlet {
	//Properties pager_pros = null;
	ServletConfig config_m = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8108906625422688656L;
/*
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Pager可在此配置？
		config_m = config;
		//servletContext:一个web工程只有一个servletContext
		Object pager_pros = config.getServletContext().getAttribute("PAGER_URLS");
		
		if(pager_pros == null){
			//查询url 配置文件，当前访问url在配置表中则生成Pager实例。
			//读取web.xml中的当前这个Servlet的初始化参数
			//config.getServletContext().getInitParameterNames();
			String pagerConfig = getServletConfig().getInitParameter("pagerConfigLocation");
			
			InputStream in;
	        try {
	        	//in = new BufferedInputStream (new FileInputStream(pagerConfig));
	        	in = config.getServletContext().getResourceAsStream(pagerConfig);
	        	Properties pros = new Properties();
	        	pros.load(in);
	        	pros.loadFromXML(in); //pros.storeToXML(fos, null);
	            in.close();
	            pager_pros = pros;
	            config.getServletContext().setAttribute("PAGER_URLS", pros);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		} else {
			//Object pager_pros = config.getServletContext().getAttribute("PAGER_URLS");
			Properties pros = (Properties) pager_pros;
			//pros.get("fff");
			//config.
			if(pros.containsKey("/list")){
				//替换{0}，可以使用MessageFormat，
				//MessageFormat.format((String)pros.get("welcome"), "snowolf"); //welcome=欢迎您，{0}！  ,欢迎您，snowolf！
				PageContext.setPage(Page.newBuilder(1, Integer.valueOf(Page.DEFAULT_PAGESIZE), "")); 
		    	//PageContext.getPage();
			}
		}
		//ClassPathResource resource = new ClassPathResource(DEFAULT_STRATEGIES_PATH, DispatcherServlet.class);
        //defaultStrategies = PropertiesLoaderUtils.loadProperties(resource);
		
		super.init(config);
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object pager_pros = config_m.getServletContext().getAttribute("PAGER_URLS");
		Properties pros = (Properties) pager_pros;
		String cur_url = request.getLocalAddr(); //"/list"
		if(pros.containsKey(cur_url)){
			//替换{0}，可以使用MessageFormat，
			//MessageFormat.format((String)pros.get("welcome"), "snowolf"); //welcome=欢迎您，{0}！  ,欢迎您，snowolf！
			PageContext.setPage(Page.newBuilder(1, Integer.valueOf(Page.DEFAULT_PAGESIZE), "")); 
	    	//PageContext.getPage();
		}
		
		super.service(request, response);
	}*/
		

	protected void render(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws Exception {  
	    //Page page = SystemContext.getPage();  
	    Page page = PageContext.getPage();  
	    if ( page != null ){  
	        //mv.addObject( "page", page);  
	        mv.addObject( "pager", page);  
	    }  
	    super.render(mv, request, response);  
	}  
	
}
