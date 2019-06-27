package com.cskaoyan.service.DeviceService.ServiceImpl;

import com.cskaoyan.mapper.DeviceFaultMapper;
import com.cskaoyan.pojo.DeviceFault;
import com.cskaoyan.service.DeviceService.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    DeviceFaultMapper deviceFaultMapper;

    @Override
    public List findAllDeviceFault() {
        List<DeviceFault>allDeviceFault = deviceFaultMapper.findAllDeviceFault();
        return allDeviceFault;
    }
}
