package com.cskaoyan.pojo;

import java.math.BigDecimal;
import java.util.Date;

/*cdate: 1561780800000
checkItem: "124123"
checkNumber: 1234
empId: "12"
empName: "12"
fCountCheckId: "15124"
measureData: "12412"
note: "214123"
orderId: "13"
qualify: 1
result: "14123"
sample: 14124
unqualify: 134123*/
public class FinalCountCheckVO extends FinalCountCheck{

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
                "FinalCountCheckVO{" +
                "empName='" + empName + '\'' +
                '}';
    }
}