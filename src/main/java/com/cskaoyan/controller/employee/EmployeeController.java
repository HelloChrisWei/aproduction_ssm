package com.cskaoyan.controller.employee;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Employee;
import com.cskaoyan.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
   @RequestMapping("employee/find")
   public String find(HttpSession session){
       ArrayList<String> list = new ArrayList<String >();
       list.add("employee:add");
       list.add("employee:edit");
       list.add("employee:delete");
       session.setAttribute("sysPermissionList",list);
       return  "employee_list";
   }
   @RequestMapping("employee/list")
   @ResponseBody
   public EasyUiDataGridResult<Employee> eployeeList(int page, int rows){
       return employeeService.selectAllEmployeePage(page, rows);
   }
  /* @RequestMapping("employee/find")
    public String employeeFind(){
       return "employee_list";
   }*/

}
