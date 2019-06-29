package com.cskaoyan.pojo;

import java.util.Date;

public class ProcessMeasureCheckVO extends ProcessMeasureCheck{
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
                "ProcessMeasureCheckVO{" +
                "empName='" + empName + '\'' +
                '}';
    }
}