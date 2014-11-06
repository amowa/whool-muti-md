package org.persist.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.LocationExample;
import org.sonatype.mavenbook.weather.model.SearchCriteria;

public interface LocationMapper {
    int countByExample(LocationExample example);

    int deleteByExample(LocationExample example);

    int deleteByPrimaryKey(String zip);

    int insert(Location record);

    int insertSelective(Location record);

    List<Location> selectByExample(LocationExample example);
    List<Location> selectByExampleWu(LocationExample example);

    Location selectByPrimaryKey(String zip);
    Location findByZip(String zip);

    int updateByExampleSelective(@Param("record") Location record, @Param("example") LocationExample example);

    int updateByExample(@Param("record") Location record, @Param("example") LocationExample example);

    int updateByPrimaryKeySelective(Location record);

    int updateByPrimaryKey(Location record);

	List<Location> findAll();

	List<Location> selectBySearchCriteria(SearchCriteria searchCriteria);
	
	//List<Location> searchAll();
}