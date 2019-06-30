package com.cskaoyan.service.quality;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.FinalCountCheck;
import com.cskaoyan.pojo.ResponseStatus;

/**
 * 
 * @version 1.0 2019/6/29
 * @author Wei
 */
public interface FinalCountCheckService {
    EasyUiDataGridResult fetchAllItems(int page, int rows);

    EasyUiDataGridResult searchById(String fCountCheckId, int page, int rows);

    EasyUiDataGridResult searchByOrderId(String orderId, int page, int rows);

    ResponseStatus deleteBatchByIds(String[] ids);

    ResponseStatus updateByPrimaryKey(FinalCountCheck record);

    ResponseStatus updateByPrimaryKeySelective(FinalCountCheck record);
}
