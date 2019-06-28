package com.cskaoyan.mapper;

import com.cskaoyan.pojo.Task;
import com.cskaoyan.pojo.TaskExample;
import java.util.List;

import com.cskaoyan.pojo.TaskVO;
import org.apache.ibatis.annotations.Param;

public interface TaskMapper {
    long countByExample(TaskExample example);

    int deleteByExample(TaskExample example);

    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    int insertSelective(Task record);

    List<Task> selectByExample(TaskExample example);

    Task selectByPrimaryKey(String taskId);

    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    // 自主添加接口
    int selectTaskCountByCondition(@Param("task") TaskVO task);

    TaskVO selectTaskByTaskId(@Param("taskId") String taskId);

    List<TaskVO> selectAllTask();

    List<TaskVO> selectAllTaskByPage(@Param("rows") int rows, @Param("offset") int offset);

    List<TaskVO> selectTaskByConditionByPage(@Param("task") TaskVO task, @Param("rows") int rows, @Param("offset") int offset);

}