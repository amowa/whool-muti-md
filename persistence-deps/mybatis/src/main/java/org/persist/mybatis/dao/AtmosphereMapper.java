package org.persist.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sonatype.mavenbook.weather.model.Atmosphere;
import org.sonatype.mavenbook.weather.model.AtmosphereExample;
import org.sonatype.mavenbook.weather.model.Wind;

public interface AtmosphereMapper {
    int countByExample(AtmosphereExample example);

    int deleteByExample(AtmosphereExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Atmosphere record);

    int insertSelective(Atmosphere record);

    List<Atmosphere> selectByExample(AtmosphereExample example);

    Atmosphere selectByPrimaryKey(Integer id);
    Atmosphere selectByWeatherId(Integer id);
    
    int updateByExampleSelective(@Param("record") Atmosphere record, @Param("example") AtmosphereExample example);

    int updateByExample(@Param("record") Atmosphere record, @Param("example") AtmosphereExample example);

    int updateByPrimaryKeySelective(Atmosphere record);

    int updateByPrimaryKey(Atmosphere record);
}