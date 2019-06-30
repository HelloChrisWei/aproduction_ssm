package com.cskaoyan.mapper;
import com.cskaoyan.pojo.Employee;
import com.cskaoyan.pojo.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(String empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);



    //自己新增方法
    List<Employee> selectAllEmployeePage(@Param("rows") int rows, @Param("offset") int offset);

    int searchEmployeeCount(@Param("employee") Employee employee);

    List<Employee> searchEmployeePage(@Param("employee") Employee employee,@Param("rows") int rows,@Param("offset") int offset );

    int addAllEmployee(Employee employee);

    int updateByPrimaryKey(Employee record);

    int deleteByPrimaryKey(String empId);

    List<Employee> selectEmployeeData();






}