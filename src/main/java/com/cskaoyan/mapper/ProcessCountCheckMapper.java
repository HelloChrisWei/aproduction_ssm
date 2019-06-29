package com.cskaoyan.mapper;

import com.cskaoyan.pojo.ProcessCountCheck;
import com.cskaoyan.pojo.ProcessCountCheckExample;
import java.util.List;

import com.cskaoyan.pojo.ProcessCountCheckVO;
import org.apache.ibatis.annotations.Param;

public interface ProcessCountCheckMapper {
    long countByExample(ProcessCountCheckExample example);

    int deleteByExample(ProcessCountCheckExample example);

    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCountCheck record);

    int insertSelective(ProcessCountCheck record);

    List<ProcessCountCheck> selectByExample(ProcessCountCheckExample example);

    ProcessCountCheck selectByPrimaryKey(String pCountCheckId);

    int updateByExampleSelective(@Param("record") ProcessCountCheck record, @Param("example") ProcessCountCheckExample example);

    int updateByExample(@Param("record") ProcessCountCheck record, @Param("example") ProcessCountCheckExample example);

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    int updateByPrimaryKey(ProcessCountCheck record);

    /*Custom Methods For VO*/
    List<ProcessCountCheckVO> selectAllRecords(@Param("rows") int rows, @Param("offset") int offset);

    List<ProcessCountCheckVO> selectByPrimaryKey4VO(@Param("example") ProcessCountCheckVO example, @Param("rows") int rows, @Param("offset") int offset);


}