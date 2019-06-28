package com.cskaoyan.controller.employee;

import com.cskaoyan.pojo.Department;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.employee.DeparmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DeparmentController {
    @Autowired
    DeparmentService deparmentService;

    @RequestMapping("department/find")
    public String find(HttpSession session) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("department:add");
        arrayList.add("department:edit");
        arrayList.add("department:delete");
        session.setAttribute("sysPermissionList", arrayList);
        return "department_list";
    }

    @RequestMapping("department/list")
    @ResponseBody
    public List<Department> list() {
        List<Department> allDeparment = deparmentService.findAllDeparment();
        return allDeparment;
    }

    //增加功能
    @RequestMapping("department/add_judge")
    public String addDeparment() {
        return "department_add";
    }

    @RequestMapping("department/add")
    public String addDeparmentPage() {
        // deparmentService.addDeparment(department);
        return "department_add";
    }

    //提交
    @RequestMapping("department/insert")
    @ResponseBody
    public ResponseStatus insertDeparment(Department department) {
        return deparmentService.addDeparment(department);

    }

    //编辑
    @RequestMapping("department/edit_judge")
    public String updateDeparment() {
        return "department_edit";
    }

    @RequestMapping("department/edit")
    public String updateDeparmentById() {
//        deparmentService.editDeparmentById(id);
        return "department_edit";
    }

    //提交
    @RequestMapping("department/update_all")
    @ResponseBody
    public ResponseStatus updateAll(Department record) {
        return deparmentService.editDeparmentById(record);
    }

    //删除操作
    @RequestMapping("department/delete_judge")
    @ResponseBody
    public ResponseStatus deleteDeparment() {
        return  new ResponseStatus();
    }

    @RequestMapping("department/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatch(String[] ids ) {
        try {
            return deparmentService.deleteByPrimaryKey(ids);
        } catch (Exception e) {
            ResponseStatus status = new ResponseStatus();
            status.setStatus(0);
            status.setMsg("删除失败");
            return status;
        }

    }
}
