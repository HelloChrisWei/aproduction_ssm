package com.cskaoyan.mapper;

import com.cskaoyan.pojo.ProcessMeasureCheck;
import com.cskaoyan.pojo.ProcessMeasureCheckExample;
import java.util.List;

import com.cskaoyan.pojo.ProcessMeasureCheckVO;
import org.apache.ibatis.annotations.Param;

public interface ProcessMeasureCheckMapper {
    long countByExample(ProcessMeasureCheckExample example);

    int deleteByExample(ProcessMeasureCheckExample example);

    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheck record);

    int insertSelective(ProcessMeasureCheck record);

    List<ProcessMeasureCheck> selectByExample(ProcessMeasureCheckExample example);

    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);

    int updateByExampleSelective(@Param("record") ProcessMeasureCheck record, @Param("example") ProcessMeasureCheckExample example);

    int updateByExample(@Param("record") ProcessMeasureCheck record, @Param("example") ProcessMeasureCheckExample example);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int updateByPrimaryKey(ProcessMeasureCheck record);

    /*-----------------Custom Methods---------------*/


    List<ProcessMeasureCheckVO> selectAllRecords();

    /*精确查询*/
    List<ProcessMeasureCheckVO> selectByPrimaryKey4VO(@Param("example") ProcessMeasureCheckVO pMeasureCheckId, @Param("rows") int rows, @Param("offset") int offset);
}