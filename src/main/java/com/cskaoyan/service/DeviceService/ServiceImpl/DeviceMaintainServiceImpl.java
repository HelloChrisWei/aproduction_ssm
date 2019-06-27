package com.cskaoyan.service.DeviceService.ServiceImpl;

import com.cskaoyan.mapper.DeviceMaintainMapper;
import com.cskaoyan.pojo.DeviceFault;
import com.cskaoyan.service.DeviceService.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {
    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;

    @Override
    public List findAllDeviceMaintain() {
        List<DeviceFault>allDeviceMaintain = deviceMaintainMapper.findAllDeviceMaintain();
        return allDeviceMaintain;
    }

}
