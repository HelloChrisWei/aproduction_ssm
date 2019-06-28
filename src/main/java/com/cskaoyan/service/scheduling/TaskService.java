package com.cskaoyan.service.scheduling;

import com.cskaoyan.exception.TaskException;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.pojo.Task;
import com.cskaoyan.pojo.TaskVO;

import java.util.List;

public interface TaskService {

    EasyUiDataGridResult<TaskVO> selectAllTaskByPage(int page, int rows);

    ResponseStatus insert(Task task);

    ResponseStatus updateByPrimaryKeySelective(Task task);

    ResponseStatus deleteBatch(String[] ids) throws TaskException;

    EasyUiDataGridResult<TaskVO> searchTaskByTaskId(String taskId, int page, int rows);

    EasyUiDataGridResult<TaskVO> searchTaskByWorkId(String workId, int page, int rows);

    EasyUiDataGridResult<TaskVO> searchTaskByManufactureSn(String manufactureSn, int page, int rows);

    TaskVO selectWorkByTaskId(String taskId);

    List<TaskVO> selectAllTask();

}
