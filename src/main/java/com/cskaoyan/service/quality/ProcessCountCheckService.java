package com.cskaoyan.service.quality;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ProcessCountCheck;
import com.cskaoyan.pojo.ResponseStatus;

/**
 * 
 * @version 1.0 2019/6/29
 * @author Wei
 */
public interface ProcessCountCheckService {
    EasyUiDataGridResult fetchAllItems(int page, int rows);

    EasyUiDataGridResult searchById(String pCountCheckId, int page, int rows);

    ResponseStatus deleteBatchByIds(String[] ids);

    ResponseStatus updateByPrimaryKey(ProcessCountCheck record);

    ResponseStatus updateByPrimaryKeySelective(ProcessCountCheck processCountCheck);


}
