package com.cskaoyan.controller.scheduling;

import com.cskaoyan.exception.TaskException;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.pojo.Task;
import com.cskaoyan.pojo.TaskVO;
import com.cskaoyan.service.scheduling.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/list")
    @ResponseBody
    public EasyUiDataGridResult task(int page, int rows){
        return taskService.selectAllTaskByPage(page, rows);
    }

    @RequestMapping("/find")
    public String taskList(){
        return "task_list";
    }

    @RequestMapping("/add_judge")
    public String taskAddJudge(){
        return "task_add";
    }

    @RequestMapping("/add")
    public String taskAdd(){
        return "task_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResponseStatus taskInsert(Task task){
        return taskService.insert(task);
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public ResponseStatus editJudge(){
        return new ResponseStatus();
    }

    @RequestMapping("/edit")
    public String edit(){
        return "task_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public ResponseStatus updateAll(Task task){
        return taskService.updateByPrimaryKeySelective(task);
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public ResponseStatus updateNote(Task task) {
        return taskService.updateByPrimaryKeySelective(task);
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatch(String[] ids) {
        try {
            return taskService.deleteBatch(ids);
        } catch (TaskException e) {
            e.printStackTrace();
            ResponseStatus status = new ResponseStatus();
            status.setStatus(0);
            status.setMsg("删除派工失败！");
            return status;
        }
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public ResponseStatus deleteJudge(){
        return new ResponseStatus();
    }

    @RequestMapping("/search_task_by_taskId")
    @ResponseBody
    public EasyUiDataGridResult searchTaskByTaskId(String taskId,int page, int rows){
        return taskService.searchTaskByTaskId(taskId,page,rows);
    }

    @RequestMapping("/search_task_by_taskWorkId")
    @ResponseBody
    public EasyUiDataGridResult searchTaskByWorkId(String workId,int page, int rows){
        return taskService.searchTaskByWorkId(workId,page,rows);
    }

    @RequestMapping("/search_task_by_taskManufactureSn")
    @ResponseBody
    public EasyUiDataGridResult searchTaskByManufactureSn(String manufactureSn, int page, int rows){
        return taskService.searchTaskByManufactureSn(manufactureSn,page,rows);
    }

    @RequestMapping("/get/{taskId}")
    @ResponseBody
    public TaskVO searchTaskDetail(@PathVariable("taskId") String taskId) {
        return taskService.selectWorkByTaskId(taskId);
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<TaskVO> searchTaskData() {
        return taskService.selectAllTask();
    }
}
