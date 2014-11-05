/**
 * 
 */
package org.mybatis;


import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.persist.mybatis.dao.LocationMapper;
import org.persist.mybatis.dao.WeatherMapper;
import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.Weather;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author M083399
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-persist.xml")
public class WeatherDAOTest extends AbstractJUnit4SpringContextTests {
	@Resource
    private WeatherMapper weatherMapper;
	
	@Resource
    private LocationMapper locationMapper;
	
	@Test
	public void testFindByPK() {
		//Weather wea = weatherMapper.selectByPrimaryKey(7);
		//assertEquals( "60202", wea.getLocationZip());
		//assertEquals( "US", wea.getRegion() );
		
		//对象关联方法
		/*Weather wea2 = weatherMapper.selectByPrimaryKey2(7);
		System.out.println(wea2.getLocation().getZip());
		System.out.println(wea2.getLocation().getCity());*/
		
		Location location = locationMapper.selectByPrimaryKey("60202");
		List<Weather> ss = weatherMapper.recentForLocation(location);
		
		
	}

}
