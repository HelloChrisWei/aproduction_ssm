package com.cskaoyan.service.impl;


import com.cskaoyan.mapper.*;
import com.cskaoyan.pojo.Device;
import com.cskaoyan.pojo.DeviceCheck;
import com.cskaoyan.pojo.DeviceFault;
import com.cskaoyan.pojo.DeviceType;
import com.cskaoyan.service.DeviceService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    @Autowired
    DeviceCheckMapper deviceCheckMapper;
    @Autowired
    DeviceFaultMapper deviceFaultMapper;
    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;
    @Autowired
    DeviceMapper deviceListMapper;
    //获取全部的设备种类，并存入集合
    @Override
    public List findAllDevice() {
        List<DeviceType>list = deviceTypeMapper.findAllDevice();
        return list;
    }

    @Override
    public List<DeviceCheck> findAllDeviceCheck() {
        List<DeviceCheck>allDeviceCheck = deviceCheckMapper.findAllDeviceCheck();
        return allDeviceCheck;
    }

    @Override
    public List findAllDeviceFault() {
        List<DeviceFault>allDeviceFault = deviceFaultMapper.findAllDeviceFault();
        return allDeviceFault;
    }

    @Override
    public List findAllDeviceMaintain() {
        List<DeviceFault>allDeviceMaintain = deviceMaintainMapper.findAllDeviceMaintain();
        return allDeviceMaintain;
    }

    @Override
    public List findAllDeviceList() {
        List<Device>allDevice = deviceListMapper.findAllDeviceList();
        return allDevice;
    }
}
