package com.cskaoyan.service.DeviceService;

import com.cskaoyan.pojo.DeviceFault;
import com.cskaoyan.pojo.EasyUiDataGridResult;

import java.util.List;


public interface DeviceFaultService {
    public List<DeviceFault> findDeviceFault();
    public EasyUiDataGridResult<DeviceFault> findAllDeviceFault(int page, int rows);
}
