package com.cskaoyan.pojo;

public class ResponseStatus {

    private int status;

    private String msg;

    private String data;

    private int error;

    private String url;

    public ResponseStatus() {
    }

    public ResponseStatus(int status, String msg, String data, int error, String url) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.error = error;
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
