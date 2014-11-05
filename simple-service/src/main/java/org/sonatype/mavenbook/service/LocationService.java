package org.sonatype.mavenbook.service;


import java.util.List;

import javax.annotation.Resource;

import org.persist.mybatis.dao.LocationMapper;
import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.LocationExample;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
//import org.javasimon.aop.Monitored;

//Spring Service Bean的标识.
@Component
@Transactional
//@Monitoredimport 
public class LocationService {
	@Resource
    private LocationMapper locationDAO;
	
	public LocationService() {
	}
	 
	public Location findByZip(String zip) {
		Location loc = locationDAO.selectByPrimaryKey(zip); //
		
		/*assertEquals( "New York", loc.getCity() );
		assertEquals( "US", loc.getRegion() );
		assertEquals( "NY", loc.getCountry() );*/
		//fail("Not yet implemented"); 
		return loc;
	}
	
	public List<Location> findAll() {
		//List<Location> locs = locationDAO.findAll(); //
		List<Location> locs = locationDAO.selectByExample(new LocationExample());
		
		/*assertEquals( "New York", loc.getCity() );
		assertEquals( "US", loc.getRegion() );
		assertEquals( "NY", loc.getCountry() );*/
		//fail("Not yet implemented"); 
		return locs;
	}
}
