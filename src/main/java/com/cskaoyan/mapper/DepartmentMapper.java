package com.cskaoyan.mapper;

import com.cskaoyan.pojo.Department;
import com.cskaoyan.pojo.DepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
    List<Department> findAllDeparment();
    int addDepartment(Department department);
    int  editDeparmentById(Department record );
    int deleteByPrimaryKey(String departmentId);
//逆向工程自动生成的方法
    long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(String departmentId);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}