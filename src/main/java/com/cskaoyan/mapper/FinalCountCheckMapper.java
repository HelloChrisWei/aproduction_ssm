package com.cskaoyan.mapper;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.FinalCountCheck;
import com.cskaoyan.pojo.FinalCountCheckExample;
import java.util.List;

import com.cskaoyan.pojo.FinalCountCheckVO;
import org.apache.ibatis.annotations.Param;

public interface FinalCountCheckMapper {
    long countByExample(FinalCountCheckExample example);

    int deleteByExample(FinalCountCheckExample example);

    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    List<FinalCountCheck> selectByExample(FinalCountCheckExample example);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByExampleSelective(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByExample(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);

    /* The following are custom methods -- Chris*/
    // TODO 和ORM类的方法整合
    List<FinalCountCheckVO> selectAllRecords(@Param("rows")int rows, @Param("offset")int offset);

    FinalCountCheckVO selectByPrimaryKey4VO(@Param("fCountCheckId") String fCountCheckId, @Param("rows")int rows, @Param("offset")int offset);

    List<FinalCountCheckVO> selectByCondition4VO(@Param("example") FinalCountCheckVO example, @Param("rows")int rows, @Param("offset")int offset);

}