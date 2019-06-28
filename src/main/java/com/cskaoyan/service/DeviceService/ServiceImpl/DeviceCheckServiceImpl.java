package com.cskaoyan.service.DeviceService.ServiceImpl;


import com.cskaoyan.mapper.*;
import com.cskaoyan.pojo.DeviceCheck;
import com.cskaoyan.service.DeviceService.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {

    @Autowired
    DeviceCheckMapper deviceCheckMapper;

    @Override
    public List<DeviceCheck> findAllDeviceCheck() {
        List<DeviceCheck>allDeviceCheck = deviceCheckMapper.findAllDeviceCheck();
        return allDeviceCheck;
    }
}
