package com.cskaoyan.mapper;

import com.cskaoyan.pojo.TechnologyRequirement;
import com.cskaoyan.pojo.TechnologyRequirementExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TechnologyRequirementMapper {
    long countByExample(TechnologyRequirementExample example);

    int deleteByExample(TechnologyRequirementExample example);

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    List<TechnologyRequirement> selectByExample(TechnologyRequirementExample example);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByExampleSelective(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByExample(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    List<TechnologyRequirement> selectAllTechnologyRequirementByPage();

    List<TechnologyRequirement> selectTechnologyRequirementById(String technologyRequirementId);

    List<TechnologyRequirement> selectTechnologyRequirementByName(String technologyName);


}