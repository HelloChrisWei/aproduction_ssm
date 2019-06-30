package com.cskaoyan.controller.TechnologyController;

import com.cskaoyan.pojo.*;
import com.cskaoyan.service.TechnologyService.TechnologyRequirementService;
import com.cskaoyan.service.TechnologyService.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TechnologyRequirementController {
    @Autowired
    TechnologyRequirementService requirementService;

    @Autowired
    TechnologyService technologyService;


    @RequestMapping("/technologyRequirement/find")
    @ResponseBody
    public ModelAndView findTechnologyRequirement() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("technologyRequirement_list");
        return modelAndView;
    }


    @RequestMapping("/technologyRequirement/list")
    @ResponseBody
    public EasyUiDataGridResult<TechnologyRequirement> technologyRequirementList(int page, int rows){
        return requirementService.selectAllTechnologyRequirement(page, rows);
    }

    //数据回显
    @RequestMapping("/technology/get/{technologyId}")
    @ResponseBody
    public Technology searchTechnologyData(@PathVariable("technologyId") String technologyId){
        return technologyService.searchTechnologyData(technologyId);
    }

    //新增操作的judge
    @RequestMapping("/technologyRequirement/add_judge")

    public String technologyRequirementAddJudge(){
        return "technologyRequirement_add";
    }

    @RequestMapping("/technologyRequirement/add")

    public String technologyRequirementAdd(){
        return "technologyRequirement_add";
    }

    @RequestMapping("/technologyRequirement/insert")
    @ResponseBody
    public ResponseStatus insertTechnologyRequirement(TechnologyRequirement record){
        return requirementService.insertTechnologyRequirement(record);
    }
    //下拉
    @RequestMapping("/technologyRequirement/get_data")
    @ResponseBody
    public List<Technology> findTechnologyData(){
        return technologyService.findTechnologyData();
    }
    //编辑
    @RequestMapping("/technologyRequirement/edit")
    @ResponseBody
    public String technologyRequirementEdit(){
        return "technologyRequirement_edit";
    }

    @RequestMapping("/technologyRequirement/edit_judge")
    @ResponseBody
    public String technologyRequirementEditJudge(){
        return "technologyRequirement_edit";
    }

    @RequestMapping("/technologyRequirement/update_all")
    @ResponseBody
    public ResponseStatus updateTechnologyRequirement(TechnologyRequirement record){
        return requirementService.updateTechnologyRequirement(record);
    }

    @RequestMapping("/technologyRequirement/delete_judge")
    @ResponseBody
    public ResponseStatus technologyRequirementDeleteJudge(){return new ResponseStatus();}

    @RequestMapping("/technologyRequirement/delete_batch")
    @ResponseBody
    public ResponseStatus deleteTechnologyRequirement(String[] ids){
        return requirementService.deleteBatchTechnologyRequirement(ids);
    }

    @RequestMapping("/technologyRequirement/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public EasyUiDataGridResult<TechnologyRequirement>
            search_technologyRequirement_by_technologyRequirementId(String searchValue,int page,int rows){
        return requirementService.search_technologyRequirement_by_technologyRequirementId(searchValue,page,rows);
    }

    @RequestMapping("/technologyRequirement/search_technologyRequirement_by_technologyName")
    @ResponseBody
    public EasyUiDataGridResult <TechnologyRequirement>
            search_technologyRequirement_by_technologyName(String searchValue,int page,int rows){
            return requirementService.search_technologyRequirement_by_technologyName(searchValue,page,rows);
    }
}
