package com.cskaoyan.mapper;

import com.cskaoyan.pojo.Work;
import com.cskaoyan.pojo.WorkExample;
import java.util.List;

import com.cskaoyan.pojo.WorkVO;
import org.apache.ibatis.annotations.Param;

public interface WorkMapper {
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(String workId);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    // 自主添加的接口
    int selectWorkCountByCondition(@Param("work") WorkVO work);

    WorkVO selectWorkByWorkId(@Param("workId") String workId);

    List<WorkVO> selectAllWork();

    List<WorkVO> selectAllWorkByPage(@Param("rows") int rows, @Param("offset") int offset);

    List<WorkVO> selectWorkByConditionByPage(@Param("work") WorkVO work, @Param("rows") int rows, @Param("offset") int offset);

}