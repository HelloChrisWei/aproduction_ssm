package com.cskaoyan.mapper;

import com.cskaoyan.pojo.Custom;
import com.cskaoyan.pojo.CustomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomMapper {
    long countByExample(CustomExample example);

    int deleteByExample(CustomExample example);

    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    List<Custom> selectByExample(CustomExample example);

    Custom selectByPrimaryKey(String customId);

    int updateByExampleSelective(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByExample(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    //自增接口
    List<Custom> selectAllCustomByPage(@Param("rows") int rows, @Param("offset") int offset);

    int selectCustomCountByCondition(@Param("custom") Custom custom);

    List<Custom> selectCustomByConditionByPage(@Param("custom") Custom custom, @Param("rows") int rows, @Param("offset") int offset);

    List<Custom> selectAllCustom();
}