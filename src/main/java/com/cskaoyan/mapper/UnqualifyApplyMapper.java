package com.cskaoyan.mapper;

import com.cskaoyan.pojo.UnqualifyApply;
import com.cskaoyan.pojo.UnqualifyApplyExample;
import java.util.List;

import com.cskaoyan.pojo.UnqualifyApplyVO;
import org.apache.ibatis.annotations.Param;

public interface UnqualifyApplyMapper {
    long countByExample(UnqualifyApplyExample example);

    int deleteByExample(UnqualifyApplyExample example);

    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    List<UnqualifyApply> selectByExample(UnqualifyApplyExample example);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByExampleSelective(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByExample(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);

    /* The following are custom methods -- Chris*/
    List<UnqualifyApplyVO> selectAllRecords(int rows, int offset);


}