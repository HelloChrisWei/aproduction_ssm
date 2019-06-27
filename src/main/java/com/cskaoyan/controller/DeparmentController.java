package com.cskaoyan.controller;

import com.cskaoyan.pojo.Department;
import com.cskaoyan.service.DeparmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DeparmentController {
    @Autowired
    DeparmentService deparmentService;
    @RequestMapping("department/find")
    public String find(){
        return "department_list";
    }
    @RequestMapping("department/list")
    @ResponseBody
    public List<Department> list(){
        List<Department> allDeparment = deparmentService.findAllDeparment();
        return allDeparment;
    }
    @RequestMapping("/home23")
    public String home(){
        return "home";
    }

}
