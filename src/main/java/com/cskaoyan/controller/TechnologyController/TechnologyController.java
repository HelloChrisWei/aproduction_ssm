package com.cskaoyan.controller.TechnologyController;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.pojo.Technology;
import com.cskaoyan.service.TechnologyService.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class TechnologyController {
    @Autowired
    TechnologyService technologyService;

    /*find页面*/
    @RequestMapping("/technology/find")
    public ModelAndView findTechnology(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("technology_list");
        return modelAndView;
    }


    /*返回list json数据*/
    @RequestMapping("technology/list")
    @ResponseBody
    public EasyUiDataGridResult<Technology> technologyList(int page,int rows){
        EasyUiDataGridResult<Technology> technologies = technologyService.selectAllTechnologyByPage(page,rows);
        return technologies;
    }
    //两个add抓包看
    @RequestMapping("/technology/add_judge")
    public String technologyAddJudge(){
        return "technology_add";
    }

    @RequestMapping("/technology/add")
    public String technologyAdd(){
        return "technology_add";
    }

    //插入操作
    //注意:返回status从前端代码看需要封装成ResponseStatus类,需要返回status给前端
    @RequestMapping("/technology/insert")
    @ResponseBody
    public ResponseStatus insertTechnology(Technology record){
        ResponseStatus responseStatus = technologyService.insertTechnology(record);
        return responseStatus;
    }

    @RequestMapping("/technology/edit_judge")
    public String technologyEditJudge(){return "technology_edit";}


    @RequestMapping("/technology/edit")
    public String technologyEdit(){return "technology_edit";}


    @RequestMapping("/technology/update_all")
    @ResponseBody
    public ResponseStatus updateTechnology(Technology record){
        return technologyService.updateTechnology(record);
    }


    @RequestMapping("/technology/delete_judge")
    @ResponseBody
    public ResponseStatus technologyDeleteJudge(){return new ResponseStatus();}


    @RequestMapping("/technology/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatchTechnology(String[] ids){
        return technologyService.deleteBatchTechnology(ids);
    }

    @RequestMapping("/technology/search_technology_by_technologyId")
    @ResponseBody
    public EasyUiDataGridResult<Technology> search_technologyPlan_by_technologyPlanId(String searchValue,int page,int rows){
        return technologyService.search_technology_by_technologyId(searchValue,page,rows);
    }

    @RequestMapping("/technologyPlan/search_technology_by_technologyName")
    @ResponseBody
    public EasyUiDataGridResult <Technology>
    search_technologyRequirement_by_technologyName(String searchValue,int page,int rows){
        return technologyService.search_technologyPlan_by_technologyName(searchValue, page, rows);
    }

}
