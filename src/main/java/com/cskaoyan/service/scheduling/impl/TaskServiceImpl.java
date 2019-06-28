package com.cskaoyan.service.scheduling.impl;

import com.cskaoyan.exception.TaskException;
import com.cskaoyan.mapper.TaskMapper;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.scheduling.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public EasyUiDataGridResult<TaskVO> selectAllTaskByPage(int page, int rows) {
        EasyUiDataGridResult<TaskVO> result = new EasyUiDataGridResult<>();
        TaskExample example = new TaskExample();

        int total = (int) taskMapper.countByExample(example);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<TaskVO> tasks = taskMapper.selectAllTaskByPage(rows, offset);
        result.setRows(tasks);
        result.setTotal(total);
        return result;
    }

    @Override
    public ResponseStatus insert(Task task) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isAdd = taskMapper.insertSelective(task);
            if (isAdd == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("该派工已存在，请更改派工编号，重新添加！");
        }
        return status;
    }

    @Override
    public ResponseStatus updateByPrimaryKeySelective(Task task) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isUpdate = taskMapper.updateByPrimaryKeySelective(task);
            if (isUpdate == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("派工修改失败！请重试！");
        }
        return status;
    }

    @Override
    public ResponseStatus deleteBatch(String[] ids) throws TaskException {
        ResponseStatus status = new ResponseStatus();
        try {
            for (String id : ids) {
                taskMapper.deleteByPrimaryKey(id);
            }
            status.setStatus(200);
            status.setMsg("OK");
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("派工批量删除失败，请重试！");
            throw new TaskException("派工批量删除失败，请重试！");
        }
        return status;
    }

    private EasyUiDataGridResult<TaskVO> pageHandle(TaskVO task, int rows, int page) {
        EasyUiDataGridResult<TaskVO> result = new EasyUiDataGridResult<>();

        int total = taskMapper.selectTaskCountByCondition(task);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<TaskVO> tasks = taskMapper.selectTaskByConditionByPage(task, rows, offset);
        result.setRows(tasks);
        result.setTotal(total);
        return result;
    }

    @Override
    public EasyUiDataGridResult<TaskVO> searchTaskByTaskId(String taskId, int page, int rows) {
        TaskVO task = new TaskVO();
        Work work = new Work();
        Manufacture manufacture = new Manufacture();

        task.setTaskId("%" + taskId +"%");
        task.setWork(work);
        task.setManufacture(manufacture);

        return pageHandle(task,rows,page);
    }

    @Override
    public EasyUiDataGridResult<TaskVO> searchTaskByWorkId(String workId, int page, int rows) {
        TaskVO task = new TaskVO();
        Work work = new Work();
        Manufacture manufacture = new Manufacture();

        work.setWorkId("%" + workId +"%");
        task.setWork(work);
        task.setManufacture(manufacture);

        return pageHandle(task,rows,page);
    }

    @Override
    public EasyUiDataGridResult<TaskVO> searchTaskByManufactureSn(String manufactureSn, int page, int rows) {
        TaskVO task = new TaskVO();
        Work work = new Work();
        Manufacture manufacture = new Manufacture();

        manufacture.setManufactureSn("%" + manufactureSn +"%");
        task.setWork(work);
        task.setManufacture(manufacture);

        return pageHandle(task,rows,page);
    }

    @Override
    public TaskVO selectWorkByTaskId(String taskId) {
        return taskMapper.selectTaskByTaskId(taskId);
    }

    @Override
    public List<TaskVO> selectAllTask() {
        return taskMapper.selectAllTask();
    }
}
