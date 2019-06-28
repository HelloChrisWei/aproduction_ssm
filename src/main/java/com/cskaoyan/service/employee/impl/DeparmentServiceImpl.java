package com.cskaoyan.service.employee.impl;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.pojo.Department;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.employee.DeparmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeparmentServiceImpl implements DeparmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public List<Department> findAllDeparment() {
        List<Department> allDeparment = departmentMapper.findAllDeparment();
        return allDeparment;
    }

    //新增
    @Override
    public ResponseStatus addDeparment(Department department) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            int i = departmentMapper.addDepartment(department);
            if (i==1){
                responseStatus.setStatus(200);
                responseStatus.setMsg("OK");
            }
        }catch (Exception e){
            e.printStackTrace();
            responseStatus.setMsg("添加失败");
            responseStatus.setStatus(0);
        }
        return responseStatus;
    }

    @Override
    public ResponseStatus editDeparmentById(Department record) {
        ResponseStatus status = new ResponseStatus();
        try{
            int i = departmentMapper.editDeparmentById(record);
            if (i==1){
                status.setStatus(200);
                status.setMsg("OK");
            }
        }catch (Exception e){
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("更新失败");
        }
        return status;
    }
    //删除
    @Override
    public ResponseStatus deleteByPrimaryKey(String[] ids) {
        ResponseStatus status = new ResponseStatus();
        try{
            for (String id : ids) {
                departmentMapper.deleteByPrimaryKey(id);
            }
            status.setStatus(200);
            status.setMsg("OK");
        }catch (Exception e){
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("删除失败");
        }
        return status;
    }




}
