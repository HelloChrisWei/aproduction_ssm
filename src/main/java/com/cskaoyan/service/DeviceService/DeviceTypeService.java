package com.cskaoyan.service.DeviceService;

import com.cskaoyan.pojo.DeviceType;
import com.cskaoyan.pojo.ResponseStatus;

import java.util.List;

public interface DeviceTypeService {
    public List findAllTypeDevice();
    public ResponseStatus insertTypeDevice(DeviceType deviceType);
}
