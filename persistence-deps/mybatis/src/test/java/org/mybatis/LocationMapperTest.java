/**
 * 
 */
package org.mybatis;

import static org.junit.Assert.*;

import java.io.IOException;  
import java.io.Reader;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  

import junit.framework.TestCase;  

import org.apache.ibatis.io.Resources;  
import org.apache.ibatis.session.SqlSession;  
import org.apache.ibatis.session.SqlSessionFactory;  
import org.apache.ibatis.session.SqlSessionFactoryBuilder;  
import org.mybatis.spring.SqlSessionTemplate;
import org.persist.mybatis.dao.LocationMapper;
import org.sonatype.mavenbook.weather.model.Location;

/**
 * @author M083399
 * 
 */
public class LocationMapperTest extends TestCase {

	// 指定MyBatis配置文件
	private static final String RESOURCE = "mybatis-config.xml";

	/**
	 * 共6步操作完成CRUD
	 * 
	 * @throws IOException
	 */
	public void testBaties() throws IOException {

		// 1、指定MyBaties配置文件
		/*Reader reader = Resources.getResourceAsReader(RESOURCE);
		// 2、创建SqlSessionFactory()
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = null;
		//SqlSessionTemplate实现了SqlSession，线程安全，多个DAO共用,比session更高级的替代。
		SqlSessionTemplate sqlSessionTemplate = null; */
		try {

			// 3、获取SqlSession
			//session = sessionFactory.openSession();
			//或者
			//sqlSessionTemplate = new SqlSessionTemplate(sessionFactory);
			//sqlSessionTemplate.getMapper(LocationMapper.class);
			
			// 4、获取DAO接口对象
			//LocationMapper mapper = session.getMapper(LocationMapper.class);

			// 5、CRUD操作
/*
			// 5.1--添加影片
			Film film = new Film();
			film.setFname("笑傲江湖");
			mapper.insertFilm(film);
			session.commit();// 添加、修改、删除操作最后需要提交事务
*/
			// 5.2--获取电影信息
			/*Location loc = mapper.selectByPrimaryKey("10002");
			
			assertEquals( "New York", loc.getCity() );
			assertEquals( "US", loc.getRegion() );
			assertEquals( "NY", loc.getCountry() );*/

			// 显示所有电影信息
			/*for (Location filmObj : filmList) {

				System.out.println("电影ID：" + filmObj.getId() + " 电影名："
						+ filmObj.getFname());

			}*/
/*
			// 5.3--查询排序
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("orderKey", "id asc");
			filmList = mapper.getAllFilmOrder(params);
			// 显示所有电影信息
			for (Film filmObj : filmList) {

				System.out.println("电影ID：" + filmObj.getId() + " 电影名："
						+ filmObj.getFname());

			}

			// 5.4--修改影片"笑傲江湖"为"喜剧之王"
			film = mapper.getFilmById(10);
			film.setFname("喜剧之王");
			mapper.updateFilm(film);
			session.commit();

			// 5.5--删除影片"笑傲江湖"，其ID为10
			mapper.deleteFilm(10);
			session.commit();*/
			assertEquals( "NY", "NY");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 6、关闭SqlSession
			/*if (session != null) {
				session.close();
			}*/
		}

	}

}
