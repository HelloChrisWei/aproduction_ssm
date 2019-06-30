package com.cskaoyan.service.employee.impl;

import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;


    @Override
    public EasyUiDataGridResult<Employee> selectAllEmployeePage(int page, int rows) {
        EasyUiDataGridResult<Employee> result = new EasyUiDataGridResult<>();
        EmployeeExample example = new EmployeeExample();
       long count =  employeeMapper.countByExample(example);
        rows = count <rows ? (int) count : rows;
        int offect = (page -1) * rows;

        List<Employee> employees = employeeMapper.selectAllEmployeePage(rows, offect);
        result.setRows(employees);
        result.setTotal((int) count);
        return result;
    }

    //新增员工
    @Override
    public ResponseStatus addAllEmployee(Employee employee) {
        ResponseStatus status = new ResponseStatus();
        try {
            int i= employeeMapper.addAllEmployee(employee);
            if (i==1){
                status.setStatus(200);
                status.setMsg("OK");
            }
        }catch (Exception e){
            e.printStackTrace();
            status.setMsg("添加失败");
            status.setStatus(0);
        }
        return status;
    }

    @Override
    public ResponseStatus updateByPrimaryKey(Employee record) {
        ResponseStatus status = new ResponseStatus();
        try {
            int i = employeeMapper.updateByPrimaryKey(record);
            if (i == 1){
                status.setStatus(200);
                status.setMsg("OK");
            }
        }catch (Exception e){
            e.printStackTrace();
            status.setMsg("更新失敗");
            status.setStatus(0);
        }
        return status;
    }

    //刪除方法
    @Override
    public ResponseStatus deleteByPrimaryKey(String[] ids) {
        ResponseStatus status = new ResponseStatus();
        try {
           for (String id :ids){
               int i = employeeMapper.deleteByPrimaryKey(id);
               if (i == 1){
                   status.setStatus(200);
                   status.setMsg("刪除成功");
               }
           }
        }catch (Exception e){
            e.printStackTrace();
            status.setMsg("刪除失敗");
            status.setStatus(0);
        }
        return status;
    }

    @Override
    public EasyUiDataGridResult<Employee> searchEmployeeById(String employeeId, int page, int rows) {
        Employee employee = new Employee();
        employee.setEmpId("%" + employeeId + "%");
        return preHandle(employee,page,rows);
    }

    @Override
    public EasyUiDataGridResult<Employee> searchEmployeeByName(String employeeName, int page, int rows) {
        Employee employee = new Employee();
        employee.setEmpName("%" + employeeName + "%");
        return preHandle(employee,page,rows);
    }

    @Override
    public List<Employee> selectEmployeeData() {
        return employeeMapper.selectEmployeeData();
    }

    private EasyUiDataGridResult<Employee> preHandle(Employee employee,int page,int rows){
        EasyUiDataGridResult<Employee> result = new EasyUiDataGridResult<>();
        //进行分页
        int count = employeeMapper.searchEmployeeCount(employee);
        rows = count < rows ? count :rows;
        int offset = (page - 1) * rows;

        List<Employee> employees = employeeMapper.searchEmployeePage(employee, rows, offset);
        result.setRows(employees);
        result.setTotal(count);
        return result;


    }

}
