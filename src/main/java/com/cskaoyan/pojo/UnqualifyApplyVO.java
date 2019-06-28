package com.cskaoyan.pojo;
/**
 * 定义一个VO对象封装SQL语句的查询结果
 * UnqualifyApplyVO继承UnqualifyApply实现属性继承
 * UnqualifyApply面向ORM不作修改
 *
 * By Wei
 */

import java.util.Date;

public class UnqualifyApplyVO extends UnqualifyApply{
    /*VO新增对象*/
    private String productName;

    /*VO新增对象*/
    private String empName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return  super.toString() + " " +
                "UnqualifyApplyVO{" +
                "productName='" + productName + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }
}