package com.cskaoyan.controller.TechnologyController;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Process;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.pojo.TechnologyPlan;
import com.cskaoyan.service.TechnologyService.ProcessService;
import com.cskaoyan.service.TechnologyService.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProcessController {
    @Autowired
    ProcessService processService;

    @Autowired
    TechnologyPlanService technologyPlanService;

    @RequestMapping("/process/find")
    public String fineProcess(){
        return "process_list";
    }

    @RequestMapping("/process/list")
    @ResponseBody
    public EasyUiDataGridResult<Process> processList(int page, int rows){
        return processService.selectAllProcessByPage(page, rows);
    }

    @RequestMapping("/process/add_judge")
    public String ProcessAddJudge(){
        return "process_add";
    }

    @RequestMapping("/process/add")
    public String technologyAdd(){
        return "process_add";
    }

    @RequestMapping("/process/insert")
    @ResponseBody
    public ResponseStatus insertProcess(Process record){
        return processService.insertProcess(record);
    }

    @RequestMapping("/process/edit_judge")
    public String ProcessEditJudge(){
        return "process_edit";
    }

    @RequestMapping("/process/edit")
    public String technologyEdit(){
        return "process_edit";
    }

    @RequestMapping("/process/update_all")
    @ResponseBody
    public ResponseStatus updateProcess(Process record){
        return processService.updateProcess(record);
    }

    @RequestMapping("/process/delete_judge")
    @ResponseBody
    public ResponseStatus ProcessDeleteJudge(){
        return new ResponseStatus();
    }

    @RequestMapping("/process/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatchProcess(String[] ids){
        return processService.deleteBatchProcess(ids);
    }
    //回显
    @RequestMapping("/process/get/{technologyPlanId}")
    @ResponseBody
    public TechnologyPlan searchTechnologyData(@PathVariable("technologyPlanId") String technologyPlanId){
        return technologyPlanService.searchTechnologyPlanData(technologyPlanId);
    }

    @RequestMapping("/technologyPlan/get_data")
    @ResponseBody
    public List<TechnologyPlan> findTechnologyData(){
        return technologyPlanService.findTechnologyPlanData();
    }

    @RequestMapping("/process/search_process_by_processId")
    @ResponseBody
    public EasyUiDataGridResult<Process> search_Process_by_ProcessId(String searchValue,int page,int rows){
        return processService.search_Process_by_ProcessId(searchValue,page,rows);
    }

    @RequestMapping("/process/search_process_by_technologyPlanId")
    @ResponseBody
    public EasyUiDataGridResult <Process>
    search_technologyRequirement_by_technologyPlanId(String searchValue,int page,int rows){
        return processService.search_Process_by_tRId(searchValue, page, rows);
    }
}
