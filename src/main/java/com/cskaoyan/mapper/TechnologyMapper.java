package com.cskaoyan.mapper;

import com.cskaoyan.pojo.Custom;
import com.cskaoyan.pojo.Technology;
import com.cskaoyan.pojo.TechnologyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechnologyMapper {
    long countByExample(TechnologyExample example);

    int deleteByExample(TechnologyExample example);

    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    List<Technology> selectByExample(TechnologyExample example);

    Technology selectByPrimaryKey(String technologyId);

    int updateByExampleSelective(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByExample(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);
    //自增接口
    List<Technology> technologyList();

    List<Technology> selectAllTechnologyByPage();

}