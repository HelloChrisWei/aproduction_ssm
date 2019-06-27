package com.cskaoyan.service;

import com.cskaoyan.pojo.DeviceType;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DeviceService {
    public List findAllDevice();
    public List findAllDeviceCheck();
    public List findAllDeviceFault();
    public List findAllDeviceMaintain();
    public List findAllDeviceList();

}
