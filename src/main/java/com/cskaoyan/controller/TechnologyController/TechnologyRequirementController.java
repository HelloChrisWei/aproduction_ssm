package com.cskaoyan.controller.TechnologyController;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.TechnologyRequirement;
import com.cskaoyan.service.TechnologyService.TechnologyRequirementService;
import com.cskaoyan.service.TechnologyService.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TechnologyRequirementController {
    @Autowired
    TechnologyRequirementService requirementService;
    @RequestMapping("/technologyRequirement/find")
    @ResponseBody
    public ModelAndView findTechnologyRequirement() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("technologyRequirement_list");
        return modelAndView;
        //return "technologyRequirement_list";
    }
    @RequestMapping("/technologyRequirement/list")
    @ResponseBody
    public EasyUiDataGridResult<TechnologyRequirement> technologyRequirementList(int page, int rows){
        return requirementService.selectAllTechnologyRequirement(page, rows);
    }
}
