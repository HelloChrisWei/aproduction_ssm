package com.cskaoyan.service.DeviceService;

import com.cskaoyan.pojo.Device;

import java.util.List;

public interface DeviceListService {
    public int addList(Device device);
    public List findAllDeviceList();
}
