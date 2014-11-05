/**
 * 
 */
package org.sonatype.mavenbook.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.Weather;
import org.sonatype.mavenbook.weather.persist.LocationDAO;
import org.sonatype.mavenbook.weather.persist.WeatherDAO;
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
    private WeatherDAO weatherDAO;
	@Resource
    private LocationDAO locationDAO;
	
	/**
	 * Test method for {@link org.sonatype.mavenbook.weather.persist.WeatherDAO#save(org.sonatype.mavenbook.weather.model.Weather)}.
	 */
	/*@Test
	public void testSave() {
		fail("Not yet implemented");
	}*/

	/**
	 * Test method for {@link org.sonatype.mavenbook.weather.persist.WeatherDAO#load(java.lang.Integer)}.
	 */
	@Test
	public void testLoad() {
		//fail("Not yet implemented");
		Weather wt = weatherDAO.load(4);
		assertNotNull("Success", wt);
		
		/*System.out.print(wt.getLocation().getCity());
		System.out.print(wt.getAtmosphere().hashCode());
		System.out.print(wt.getCondition().getTemp());
		System.out.print(wt.getWind().getSpeed());*/
		
	}

	/**
	 * Test method for {@link org.sonatype.mavenbook.weather.persist.WeatherDAO#recentForLocation(org.sonatype.mavenbook.weather.model.Location)}.
	 */
	@Test
	public void testRecentForLocation() {
		//fail("Not yet implemented");
		
		Location loc = locationDAO.findByZip("10002");
		List<Weather> wts = weatherDAO.recentForLocation(loc);
		assertNotNull("Success", wts);
		
	}

}
