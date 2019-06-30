package com.cskaoyan.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class ProcessCountCheckVO extends ProcessCountCheck{
    private String empName;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return  super.toString() + " " +
                "ProcessCountCheckVO{" +
                "empName='" + empName + '\'' +
                '}';
    }
}