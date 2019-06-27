package com.cskaoyan.pojo;

import java.util.List;

public class EasyUiDataGridResult<T> {

    private int total;

    private List<T> rows;

    public int getTotal(int total) {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

}
