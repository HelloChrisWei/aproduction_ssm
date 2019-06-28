package com.cskaoyan.service.DeviceService.ServiceImpl;

import com.cskaoyan.exception.OrderException;
import com.cskaoyan.mapper.DeviceTypeMapper;
import com.cskaoyan.pojo.DeviceType;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.DeviceService.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    //获取全部的设备种类，并存入集合
    @Override
    public List findAllTypeDevice() {
        List<DeviceType>list = deviceTypeMapper.findAllDevice();
        return list;
    }

    @Override
    public ResponseStatus insertTypeDevice(DeviceType deviceType) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            int i = deviceTypeMapper.insertTypeDevice(deviceType);
            if (i == 1) {
                responseStatus.setMsg("添加成功");
                responseStatus.setStatus(200);
            }
        }catch (Exception e) {
            e.printStackTrace();
            responseStatus.setStatus(0);
            responseStatus.setMsg("无法插入");
        }
        return responseStatus;
    }

    @Override
    public ResponseStatus deleteType(String[] ids) {
        ResponseStatus status = new ResponseStatus();
        try {
            for (String id : ids) {
                deviceTypeMapper.deleteByPrimaryKey(id);
            }
            status.setStatus(200);
            status.setMsg("OK");
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(520);
            status.setMsg("批量删除有误");
        }
        return status;
    }
}