package com.cskaoyan.controller.employee;

import com.cskaoyan.pojo.Department;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Employee;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.employee.EmployeeService;
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
   public String find(/*HttpSession session*/){
       /*ArrayList<String> list = new ArrayList<String >();
       list.add("employee:add");
       list.add("employee:edit");
       list.add("employee:delete");
       session.setAttribute("sysPermissionList",list);*/
       return  "employee_list";
   }
   @RequestMapping("employee/list")
   @ResponseBody
   public EasyUiDataGridResult<Employee> eployeeList(int page, int rows){
       return employeeService.selectAllEmployeePage(page, rows);
   }
   //增加功能
    @RequestMapping("employee/add_judge")
    public String emplopAddJudge(){
       return "employee_add";
    }

    @RequestMapping("employee/add")
    public String employeeAdd(){
        return "employee_add";
    }

    @RequestMapping("employee/insert")
    @ResponseBody
    public ResponseStatus insertDate(Employee employee){
        ResponseStatus status = employeeService.addAllEmployee(employee);
        return status;
    }

    //編輯
    @RequestMapping("employee/edit_judge")
    public String employeeJudge(){
       return "employee_edit";
    }

    @RequestMapping("employee/edit")
    public String employeeEdit(){
       return "employee_edit";
    }

    @RequestMapping("employee/update_all")
    @ResponseBody
    public ResponseStatus employeeUpdate(Employee employee){
        ResponseStatus status = employeeService.updateByPrimaryKey(employee);
        return status;
    }

    //刪除功能
    @RequestMapping("employee/delete_judge")
    @ResponseBody
    public ResponseStatus employeeDeleteJudge(){
       return new ResponseStatus();
    }

    @RequestMapping("employee/delete_batch")
    @ResponseBody
    public  ResponseStatus employeeDeleteBatch(String[] ids){
       try {
           return employeeService.deleteByPrimaryKey(ids);
       }catch (Exception e){
           ResponseStatus status = new ResponseStatus();
           status.setStatus(0);
           status.setMsg("刪除成功");
           return status;
       }
    }

    //按照ID查詢功能
    @RequestMapping("employee/search_employee_by_employeeId")
    @ResponseBody
    public EasyUiDataGridResult searchEmployeeById(String searchValue ,int page,int rows){
       return employeeService.searchEmployeeById(searchValue,page,rows);
    }

    //按照Name查询
    @RequestMapping("employee/search_employee_by_employeeName")
    @ResponseBody
    public EasyUiDataGridResult searchEmployeeByName(String searchValue,int page ,int rows){
       return employeeService.searchEmployeeByName(searchValue,page,rows);
    }

    //employee 的data获取
    @RequestMapping("employee/get_data")
    @ResponseBody
    public List<Employee> getData(){
       return employeeService.selectEmployeeData();

    }
}
