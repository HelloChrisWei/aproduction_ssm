package com.cskaoyan.service.bean;

import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.pojo.Employee;
import com.cskaoyan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employees = employeeMapper.findAllEmployee();
        return employees;
    }
}
