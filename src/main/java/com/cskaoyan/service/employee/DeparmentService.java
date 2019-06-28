package com.cskaoyan.service.employee;
import com.cskaoyan.pojo.Department;
import com.cskaoyan.pojo.ResponseStatus;

import java.util.List;

public interface DeparmentService {
    List<Department> findAllDeparment();
    ResponseStatus addDeparment(Department department);
    ResponseStatus editDeparmentById(Department record);
    ResponseStatus deleteByPrimaryKey(String[] ids);

}
