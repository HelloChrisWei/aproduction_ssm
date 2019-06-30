package com.cskaoyan.mapper;

import com.cskaoyan.pojo.FinalMeasuretCheck;
import com.cskaoyan.pojo.FinalMeasuretCheckExample;
import java.util.List;

import com.cskaoyan.pojo.FinalMeasuretCheckVO;
import org.apache.ibatis.annotations.Param;

public interface FinalMeasuretCheckMapper {
    long countByExample(FinalMeasuretCheckExample example);

    int deleteByExample(FinalMeasuretCheckExample example);

    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    List<FinalMeasuretCheck> selectByExample(FinalMeasuretCheckExample example);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByExampleSelective(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByExample(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);

    /* The following are custom methods -- Chris */
    List<FinalMeasuretCheckVO> selectAllRecords();

    List<FinalMeasuretCheckVO> selectByPrimaryKey4VO(@Param("fMeasureCheckId") String fMeasureCheckId, @Param("rows") int rows, @Param("offset") int offset);

    List<FinalMeasuretCheckVO> selectByCondition4VO(@Param("example") FinalMeasuretCheckVO example, @Param("rows") int rows, @Param("offset") int offset);
}