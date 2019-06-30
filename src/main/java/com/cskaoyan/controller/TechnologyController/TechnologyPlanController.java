package com.cskaoyan.controller.TechnologyController;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.pojo.Technology;
import com.cskaoyan.pojo.TechnologyPlan;
import com.cskaoyan.service.TechnologyService.TechnologyPlanService;
import com.cskaoyan.service.TechnologyService.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TechnologyPlanController {
    @Autowired
    TechnologyPlanService technologyPlanService;

    @Autowired
    TechnologyService technologyService;

    @RequestMapping("/technologyPlan/find")
    public String findTechnologyPlan(){
        return "technologyPlan_list";
    }

    @RequestMapping("/technologyPlan/list")
    @ResponseBody
    public EasyUiDataGridResult<TechnologyPlan> technologyPlanList(int page, int rows){
        return technologyPlanService.selectAllTechnologyPlanByPage(page, rows);
    }

    @RequestMapping("/technologyPlan/add_judge")
    public String technologyPlanAddJudge(){
        return "technologyPlan_add";
    }

    @RequestMapping("/technologyPlan/add")
    public String technologyAdd(){
        return "technologyPlan_add";
    }

    @RequestMapping("/technologyPlan/insert")
    @ResponseBody
    public ResponseStatus insertTechnologyPlan(TechnologyPlan record){
        return technologyPlanService.insertTechnologyPlan(record);
    }

    @RequestMapping("/technologyPlan/edit_judge")
    public String technologyPlanEditJudge(){
        return "technologyPlan_edit";
    }

    @RequestMapping("/technologyPlan/edit")
    public String technologyEdit(){
        return "technologyPlan_edit";
    }

    @RequestMapping("/technologyPlan/update_all")
    @ResponseBody
    public ResponseStatus updateTechnologyPlan(TechnologyPlan record){
        return technologyPlanService.updateTechnologyPlan(record);
    }

    @RequestMapping("/technologyPlan/delete_judge")
    @ResponseBody
    public ResponseStatus technologyPlanDeleteJudge(){
        return new ResponseStatus();
    }

    @RequestMapping("/technologyPlan/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatchTechnologyPlan(String[] ids){
        return technologyPlanService.deleteBatchTechnologyPlan(ids);
    }
    //回显
    @RequestMapping("/technologyPlan/get/{technologyId}")
    @ResponseBody
    public Technology searchTechnologyData(@PathVariable("technologyId") String technologyId){
        return technologyService.searchTechnologyData(technologyId);
    }

    @RequestMapping("/technology/get_data")
    @ResponseBody
    public List<Technology> findTechnologyData(){
        return technologyService.findTechnologyData();
    }

    @RequestMapping("/technologyPlan/search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public EasyUiDataGridResult<TechnologyPlan> search_technologyPlan_by_technologyPlanId(String searchValue,int page,int rows){
        return technologyPlanService.search_technologyPlan_by_technologyPlanId(searchValue,page,rows);
    }

    @RequestMapping("/technologyPlan/search_technologyPlan_by_technologyName")
    @ResponseBody
    public EasyUiDataGridResult <TechnologyPlan>
    search_technologyRequirement_by_technologyName(String searchValue,int page,int rows){
        return technologyPlanService.search_technologyPlan_by_technologyName(searchValue, page, rows);
    }
}
