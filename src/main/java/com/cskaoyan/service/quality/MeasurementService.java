package com.cskaoyan.service.quality;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.FinalMeasuretCheck;
import com.cskaoyan.pojo.ResponseStatus;

public interface MeasurementService {
    EasyUiDataGridResult fetchAllItems(int page, int rows);

    EasyUiDataGridResult searchById(String fMeasureCheckId, int page, int rows);

    ResponseStatus deleteBatchByIds(String[] ids);

    ResponseStatus updateByPrimaryKey(FinalMeasuretCheck record);

    ResponseStatus updateByPrimaryKeySelective(FinalMeasuretCheck finalMeasuretCheck);

    EasyUiDataGridResult searchByOrderId(String orderId, int page, int rows);

    ResponseStatus insert(FinalMeasuretCheck record);
}
