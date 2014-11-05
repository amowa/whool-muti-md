package org.persist.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sonatype.mavenbook.weather.model.Condition;
import org.sonatype.mavenbook.weather.model.ConditionExample;

public interface ConditionMapper {
    int countByExample(ConditionExample example);

    int deleteByExample(ConditionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Condition record);

    int insertSelective(Condition record);

    List<Condition> selectByExample(ConditionExample example);

    Condition selectByPrimaryKey(Integer id);
    Condition selectByWeatherId(Integer id);

    int updateByExampleSelective(@Param("record") Condition record, @Param("example") ConditionExample example);

    int updateByExample(@Param("record") Condition record, @Param("example") ConditionExample example);

    int updateByPrimaryKeySelective(Condition record);

    int updateByPrimaryKey(Condition record);
}