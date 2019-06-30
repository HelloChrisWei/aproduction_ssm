package com.cskaoyan.service.employee;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Employee;
import com.cskaoyan.pojo.ResponseStatus;

import java.util.List;

public interface EmployeeService {

    EasyUiDataGridResult<Employee> selectAllEmployeePage(int page ,int rows);

    ResponseStatus addAllEmployee(Employee employee);

    ResponseStatus updateByPrimaryKey(Employee record);

    ResponseStatus deleteByPrimaryKey(String[] ids);

    EasyUiDataGridResult<Employee> searchEmployeeById(String employeeId,int page,int rows);

    EasyUiDataGridResult<Employee> searchEmployeeByName(String employeeName,int page,int rows);

    List<Employee> selectEmployeeData();
}
