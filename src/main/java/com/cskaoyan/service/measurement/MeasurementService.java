package com.cskaoyan.service.measurement;

import com.cskaoyan.pojo.EasyUiDataGridResult;

public interface MeasurementService {
    EasyUiDataGridResult getMeasurementList(int page, int rows);
}
