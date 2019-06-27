package com.cskaoyan.controller;

import com.cskaoyan.pojo.Employee;
import com.cskaoyan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
   @RequestMapping("employee/find")
   public String find(){
       return  "employee_list";
   }
   @RequestMapping("employee/list")
   @ResponseBody
   public List<Employee> list(){
       List<Employee> allEmployee = employeeService.findAllEmployee();
       return allEmployee;
   }

}
