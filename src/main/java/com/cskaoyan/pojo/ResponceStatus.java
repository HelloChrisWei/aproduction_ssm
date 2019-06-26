package com.cskaoyan.pojo;

public class ResponceStatus {
    private int status;
    private String massage;

    public ResponceStatus() {
    }

    public ResponceStatus(int status, String massage) {
        this.status = status;
        this.massage = massage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
