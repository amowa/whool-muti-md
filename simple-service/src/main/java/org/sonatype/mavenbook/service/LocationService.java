package org.sonatype.mavenbook.service;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.persist.mybatis.dao.LocationMapper;
import org.sonatype.mavenbook.utils.SearchFilter;
import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.LocationExample;
import org.sonatype.mavenbook.weather.model.SearchCriteria;
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
	
	/*条件查询*/
	public List<Location> findAll(Map<String, Object> searchParams) {
		//List<Location> locs = locationDAO.findAll(); //
		LocationExample exampleCriteria = new LocationExample();
		
		exampleCriteria.and().andCityLike("%Bell%"); 
		exampleCriteria.and().andCityLike("%Gard%");
		//exampleCriteria.or().andCityLike("%New%");
		
		//加入排序
		exampleCriteria.setOrderByClause("ZIP Desc");
		List<Location> locs = locationDAO.selectByExample(exampleCriteria);
		/*
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.and().Like("CITY", "%Bell%");
		
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		
		//Specification<Task> spec = buildSpecification(userId, searchParams);
		List<Location> locsx = locationDAO.selectBySearchCriteria(searchCriteria);
		*/
		/*assertEquals( "New York", loc.getCity() );
		assertEquals( "US", loc.getRegion() );
		assertEquals( "NY", loc.getCountry() );*/
		//fail("Not yet implemented"); 
		return locs;
	}
		
	
	/**
	 * 创建动态查询条件组合.
	 */
	/*private Specification<Task> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		//filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<Task> spec = DynamicSpecifications.bySearchFilter(filters.values(), Task.class);
		return spec;
	}*/
	
}
