package org.persist.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.Weather;
import org.sonatype.mavenbook.weather.model.WeatherExample;

public interface WeatherMapper {
    int countByExample(WeatherExample example);

    int deleteByExample(WeatherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Weather record);
    void save(Weather record);

    int insertSelective(Weather record);

    List<Weather> selectByExample(WeatherExample example);

    Weather selectByPrimaryKey(Integer id);
    Weather selectByPrimaryKey2(Integer id);

    int updateByExampleSelective(@Param("record") Weather record, @Param("example") WeatherExample example);

    int updateByExample(@Param("record") Weather record, @Param("example") WeatherExample example);

    int updateByPrimaryKeySelective(Weather record);

    int updateByPrimaryKey(Weather record);
    
    /*获取地区的天气历史记录*/
    List<Weather> recentForLocation(Location location);
    
}

