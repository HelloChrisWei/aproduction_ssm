package com.cskaoyan.controller;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Technology;
import com.cskaoyan.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class TechnologyController {
    @Autowired
    TechnologyService technologyService;
    /*home*/
    @RequestMapping("home")
    public ModelAndView findHome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }
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

    @RequestMapping("/technology/add_judge")
    public String technologyAdd(){
        return "technology_add";
    }
    @RequestMapping("/technology/add")
    public String technologyAddJudge(){
        return "technology_add";
    }
    @RequestMapping("/technology/insert")
    @ResponseBody
    public boolean insertTechnology(Technology technology){
        boolean technology1 = technologyService.insertTechnology(technology);
        return true;
    }
}
