package com.cskaoyan.service.DeviceService.ServiceImpl;


import com.cskaoyan.mapper.*;
import com.cskaoyan.pojo.DeviceCheck;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.DeviceService.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public ResponseStatus insertCheckDevice(DeviceCheck deviceCheck) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            int i = deviceCheckMapper.insert(deviceCheck);
            if (i == 1) {
                responseStatus.setMsg("添加成功");
                responseStatus.setStatus(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseStatus.setStatus(520);
            responseStatus.setMsg("无法插入");
        }
        return responseStatus;
    }
}
