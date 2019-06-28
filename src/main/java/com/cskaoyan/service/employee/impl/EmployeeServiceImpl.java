package com.cskaoyan.service.employee.impl;

import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Employee;
import com.cskaoyan.pojo.EmployeeExample;
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

}
