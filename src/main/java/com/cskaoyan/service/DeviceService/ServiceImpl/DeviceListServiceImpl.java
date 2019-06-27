package com.cskaoyan.service.DeviceService.ServiceImpl;

import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.pojo.Device;
import com.cskaoyan.pojo.DeviceType;
import com.cskaoyan.service.DeviceService.DeviceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceListServiceImpl implements DeviceListService {
    @Autowired
    DeviceMapper deviceListMapper;

    @Override
    public List findAllDeviceList() {
        List<Device>allDevice = deviceListMapper.findAllDeviceList();
        return allDevice;
    }

    @Override
    public int addList(Device device) {
        int i = deviceListMapper.addList(device);
        return i;
    }

}
