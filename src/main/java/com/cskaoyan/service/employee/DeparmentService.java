package com.cskaoyan.service.employee;
import com.cskaoyan.pojo.Department;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;

import java.util.List;

public interface DeparmentService {
    EasyUiDataGridResult<Department> selectAllDepartmentPage(int page,int rows);

    ResponseStatus addDeparment(Department department);

    ResponseStatus editDeparmentById(Department record);

    ResponseStatus deleteByPrimaryKey(String[] ids);

   List<Department> selectDepartmentName();

   EasyUiDataGridResult<Department> searchDepartmentById(String departmentId, int page, int rows);

   EasyUiDataGridResult<Department> searchDepartmentByName(String departmentName, int page, int rows);

    Department selectByPrimaryKey(String departmentId);
}
