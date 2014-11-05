/**
 * 
 */
package org.mybatis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.persist.mybatis.dao.LocationMapper;
import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.LocationExample;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author M083399
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-persist.xml")
public class LocationDAOTest extends AbstractJUnit4SpringContextTests {
	@Resource
    private LocationMapper locationMapper;
	
	/**
	 * Test method for
	 * {@link org.sonatype.mavenbook.weather.persist.LocationDAO#findByZip(java.lang.String)}
	 */
	@Test
	public void testFindByZip() {
		Location loc = locationMapper.selectByPrimaryKey("10002");
		
		assertEquals( "New York", loc.getCity() );
		assertEquals( "US", loc.getRegion() );
		assertEquals( "NY", loc.getCountry() );
		//fail("Not yet implemented"); 
		
		//List<Location> locs = locationMapper.findAll();
		List<Location> locs = locationMapper.selectByExample(new LocationExample());
		assertNotNull("Success", locs);
	}

	/**
	 * Test method for
	 * {@link org.sonatype.mavenbook.weather.persist.LocationDAO#all()}.
	 */
	@Test
	public void testSelectMutilOr() {
		//fail("Not yet implemented");

		LocationExample exampleCriteria = new LocationExample();
		
		//Criteria criteria = exampleCriteria.createCriteria();
		//criteria.andCityLike("%Bell%");
		
		//oredCriteria  设置有序的多个查询条件
		exampleCriteria.or().andCityLike("%Bell%");
		exampleCriteria.or().andCityLike("%New%"); //or New  separator="or"
				
		//加入排序
		exampleCriteria.setOrderByClause("ZIP Desc");
		
		List<Location> locs = locationMapper.selectByExample(exampleCriteria);
		exampleCriteria.clear();
		
		assertNotNull("Success", locs);
		for(Location loca:locs){
			System.out.print(loca.getZip());
			System.out.print(", ");
			System.out.println(loca.getCity());
		}
		
	}
	
	@Test
	public void testSelectMutilAnd() {
		LocationExample exampleCriteria = new LocationExample();
		exampleCriteria.and().andCityLike("%Bell%"); 
		exampleCriteria.and().andCityLike("%Gard%");
		//exampleCriteria.or().andCityLike("%New%");
		//加入排序
		exampleCriteria.setOrderByClause("ZIP Desc");
		List<Location> locs2 = locationMapper.selectByExampleWu(exampleCriteria);
		exampleCriteria.clear();
		assertNotNull("Success", locs2);
		for(Location loca:locs2){
			System.out.print(loca.getZip());
			System.out.print(", ");
			System.out.println(loca.getCity());
		}
	}

}
