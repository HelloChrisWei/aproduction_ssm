package com.cskaoyan.mapper;

import com.cskaoyan.pojo.MaterialReceive;
import com.cskaoyan.pojo.MaterialReceiveExample;
import java.util.List;

import com.cskaoyan.pojo.MaterialReceiveVO;
import org.apache.ibatis.annotations.Param;

public interface MaterialReceiveMapper {
    long countByExample(MaterialReceiveExample example);

    int deleteByExample(MaterialReceiveExample example);

    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    List<MaterialReceive> selectByExample(MaterialReceiveExample example);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByExampleSelective(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByExample(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);

    // 自主创建
    List<MaterialReceiveVO> selectAllMaterialReceiveByPage(@Param("rows") int rows, @Param("offset") int offset);

    int selectMaterialReceiveCountByCondition(@Param("materialReceive") MaterialReceiveVO materialReceive);

    List<MaterialReceiveVO> selectMaterialReceiveByConditionByPage(@Param("materialReceive") MaterialReceiveVO materialReceive, @Param("rows") int rows, @Param("offset") int offset);

    List<MaterialReceiveVO> selectAllMaterialReceive();

    MaterialReceiveVO selectMaterialReceiveByReceiveId(@Param("receiveId") String receiveId);
}