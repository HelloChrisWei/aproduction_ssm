package com.cskaoyan.service.employee;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Employee;

public interface EmployeeService {
    EasyUiDataGridResult<Employee> selectAllEmployeePage(int page ,int rows);

}
