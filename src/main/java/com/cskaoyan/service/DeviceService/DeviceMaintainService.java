package com.cskaoyan.service.DeviceService;

import com.cskaoyan.pojo.DeviceMaintain;
import com.cskaoyan.pojo.EasyUiDataGridResult;

import java.util.List;

public interface DeviceMaintainService {
    public List<DeviceMaintain> findDeviceMaintain();
    public EasyUiDataGridResult<DeviceMaintain> findAllDeviceMaintain(int page, int rows);
}
