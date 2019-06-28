package com.cskaoyan.controller.scheduling;

import com.cskaoyan.exception.WorkException;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.pojo.Work;
import com.cskaoyan.pojo.WorkVO;
import com.cskaoyan.service.scheduling.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private WorkService workService;

    @RequestMapping("/list")
    @ResponseBody
    public EasyUiDataGridResult work(int page, int rows) {
        return workService.selectAllWorkByPage(page, rows);
    }

    @RequestMapping("/find")
    public String workList() {
        return "work_list";
    }

    @RequestMapping("/add_judge")
    public String workAddJudge() {
        return "work_add";
    }

    @RequestMapping("/add")
    public String workAdd() {
        return "work_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResponseStatus workInsert(Work work) {
        return workService.insert(work);
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public ResponseStatus editJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("/edit")
    public String edit() {
        return "work_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public ResponseStatus updateAll(Work work) {
        return workService.updateByPrimaryKeySelective(work);
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatch(String[] ids) {
        try {
            return workService.deleteBatch(ids);
        } catch (WorkException e) {
            e.printStackTrace();
            ResponseStatus status = new ResponseStatus();
            status.setStatus(0);
            status.setMsg("删除作业失败！");
            return status;
        }
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public ResponseStatus deleteJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("/search_work_by_workId")
    @ResponseBody
    public EasyUiDataGridResult searchWorkByWorkId(String workId, int page, int rows) {
        return workService.searchWorkByWorkId(workId, page, rows);
    }

    @RequestMapping("/search_work_by_workProduct")
    @ResponseBody
    public EasyUiDataGridResult searchWorkByProductName(String productName, int page, int rows) {
        return workService.searchWorkByProductName(productName, page, rows);
    }

    @RequestMapping("/search_work_by_workDevice")
    @ResponseBody
    public EasyUiDataGridResult searchWorkByDeviceName(String deviceName, int page, int rows) {
        return workService.searchWorkByDeviceName(deviceName, page, rows);
    }

    @RequestMapping("/search_work_by_workProcess")
    @ResponseBody
    public EasyUiDataGridResult searchWorkByProcessId(String processId, int page, int rows) {
        return workService.searchWorkByProcessId(processId, page, rows);
    }

    @RequestMapping("/get/{workId}")
    @ResponseBody
    public WorkVO searchWorkDetail(@PathVariable("workId") String workId){
        return workService.selectWorkByWorkId(workId);
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<WorkVO> searchWorkData() {
        return workService.selectAllWork();
    }

}
