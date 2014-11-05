package org.persist.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sonatype.mavenbook.weather.model.Condition;
import org.sonatype.mavenbook.weather.model.Wind;
import org.sonatype.mavenbook.weather.model.WindExample;

public interface WindMapper {
    int countByExample(WindExample example);

    int deleteByExample(WindExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Wind record);

    int insertSelective(Wind record);

    List<Wind> selectByExample(WindExample example);

    Wind selectByPrimaryKey(Integer id);
    Wind selectByWeatherId(Integer id);
    
    int updateByExampleSelective(@Param("record") Wind record, @Param("example") WindExample example);

    int updateByExample(@Param("record") Wind record, @Param("example") WindExample example);

    int updateByPrimaryKeySelective(Wind record);

    int updateByPrimaryKey(Wind record);
}