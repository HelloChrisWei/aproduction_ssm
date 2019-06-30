package com.cskaoyan.service.employee.impl;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.pojo.Department;
import com.cskaoyan.pojo.DepartmentExample;
import com.cskaoyan.pojo.EasyUiDataGridResult;
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
    public EasyUiDataGridResult<Department> selectAllDepartmentPage(int page, int rows) {
        EasyUiDataGridResult<Department> result = new EasyUiDataGridResult<Department>();
        DepartmentExample example = new DepartmentExample();
       long count = departmentMapper.countByExample(example);
        rows = count < rows ? (int) count :rows;
        int offset = (page - 1) * rows;

        List<Department> departments = departmentMapper.selectAllDepartmentPage(rows, offset);
        result.setRows(departments);
        result.setTotal((int) count);
        return result;
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

    @Override
    public List<Department> selectDepartmentName() {
        return departmentMapper.selectDepartmentName();
    }

    @Override
    public EasyUiDataGridResult<Department> searchDepartmentById(String departmentId, int page, int rows) {
        Department department = new Department();
        department.setDepartmentId("%" + departmentId + "%");
        return preHandle(department,page,rows);
    }

    @Override
    public EasyUiDataGridResult<Department> searchDepartmentByName(String departmentName, int page, int rows) {
        Department department = new Department();
        department.setDepartmentName("%" + departmentName + "%");
        return preHandle(department,page,rows);
    }

    @Override
    public Department selectByPrimaryKey(String departmentId) {
        return departmentMapper.selectByPrimaryKey(departmentId);
    }

    private  EasyUiDataGridResult<Department> preHandle(Department department,int page,int rows){
        EasyUiDataGridResult<Department> result = new EasyUiDataGridResult<Department>();
    //獲取數量進行分頁
        int count = departmentMapper.searchDepartmentCount(department);
        rows = count <rows ? count :rows;
        int offset = (page - 1) * rows;

        List<Department> departments = departmentMapper.searchDepartmentPage(department, rows, offset);
        result.setRows(departments);
        result.setTotal(count);
        return result;
    }


}

