package com.cskaoyan.service.DeviceService;

import com.cskaoyan.pojo.Device;
import com.cskaoyan.pojo.EasyUiDataGridResult;

import java.util.List;

public interface DeviceListService {
    public List<Device> findDeviceList();
    public int addList(Device device);
    public EasyUiDataGridResult<Device> findAllDeviceList(int page, int rows);
    public Device searchDeviceById(String deviceId);
}
