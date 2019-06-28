package com.cskaoyan.pojo;

public class FinalMeasuretCheckVO extends FinalMeasuretCheck{

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
                "FinalMeasuretCheckVO{" +
                "empName='" + empName + '\'' +
                '}';
    }
}