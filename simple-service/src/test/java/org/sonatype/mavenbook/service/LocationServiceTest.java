/**
 * 
 */
package org.sonatype.mavenbook.service;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sonatype.mavenbook.weather.model.Location;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author M083399
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-persist.xml","classpath:applicationContext-service.xml"})
public class LocationServiceTest extends AbstractJUnit4SpringContextTests {
	@Resource
    private LocationService locationService;
	
	/**
	 * Test method for
	 * {@link org.sonatype.mavenbook.weather.persist.LocationDAO#findByZip(java.lang.String)}
	 */
	@Test
	public void testFindByZip() {
		Location loc = locationService.findByZip("10002");
		
		assertEquals( "New York", loc.getCity() );
		assertEquals( "US", loc.getRegion() );
		assertEquals( "NY", loc.getCountry() );
		//fail("Not yet implemented"); 
	}

	/**
	 * Test method for
	 * {@link org.sonatype.mavenbook.weather.persist.LocationDAO#all()}.
	 */
	/*@Test
	public void testAll() {
		//fail("Not yet implemented");
		List<Location> locs=locationDAO.all();
		assertNotNull("Success", locs);
	}*/

}
