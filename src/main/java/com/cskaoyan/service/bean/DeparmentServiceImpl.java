package com.cskaoyan.service.bean;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.pojo.Department;
import com.cskaoyan.service.DeparmentService;
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
}
