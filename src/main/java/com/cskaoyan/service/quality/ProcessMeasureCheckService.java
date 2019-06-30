package com.cskaoyan.service.quality;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.FinalCountCheck;
import com.cskaoyan.pojo.ProcessMeasureCheck;
import com.cskaoyan.pojo.ResponseStatus;

/**
 * 
 * @version 1.0 2019/6/29
 * @author Wei
 */
public interface ProcessMeasureCheckService {
    EasyUiDataGridResult fetchAllItems(int page, int rows);

    EasyUiDataGridResult searchById(String pMeasureCheckId, int page, int rows);

    ResponseStatus deleteBatchByIds(String[] ids);

    ResponseStatus updateByPrimaryKey(ProcessMeasureCheck record);

    ResponseStatus updateByPrimaryKeySelective(ProcessMeasureCheck record);
}
