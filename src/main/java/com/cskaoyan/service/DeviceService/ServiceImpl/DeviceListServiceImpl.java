package com.cskaoyan.service.DeviceService.ServiceImpl;

import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.mapper.DeviceTypeMapper;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.DeviceService.DeviceListService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceListServiceImpl implements DeviceListService {
    @Autowired
    DeviceMapper deviceListMapper;
    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    @Override
    public List<Device> findDeviceList(){
        return deviceListMapper.findAllDeviceList();
    }
    @Override
    public EasyUiDataGridResult<DeviceVO> findAllDeviceList(int page, int rows) {
        PageHelper.startPage(page,rows);
        //创建EasyUiDataGridResult类，目的:封装list数据
        EasyUiDataGridResult<DeviceVO> easyUiDataGridResult = new EasyUiDataGridResult<>();
        //目的:获取总条目数
        DeviceExample deviceExample = new DeviceExample();
        //封装list
        easyUiDataGridResult.setRows( deviceListMapper.findDeviceList());
        //获取总数
        easyUiDataGridResult.setTotal((int) deviceListMapper.countByExample(deviceExample));
        return easyUiDataGridResult;
    }

    @Override
    public Device searchDeviceById(String deviceId) {
        return deviceListMapper.selectByPrimaryKey(deviceId);
    }

    @Override
    public ResponseStatus addList(Device device) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            int i = deviceListMapper.addList(device);
            if (i == 1) {
                responseStatus.setMsg("添加成功");
                responseStatus.setStatus(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseStatus.setStatus(0);
            responseStatus.setMsg("无法插入");
        }
        return responseStatus;
    }
    @Override
    public ResponseStatus deleteDevice(String[] ids) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            for (String id : ids) {
                deviceListMapper.deleteByPrimaryKey(id);
            }
            responseStatus.setStatus(200);
            responseStatus.setMsg("OK");
        } catch (Exception e) {
            e.printStackTrace();
            responseStatus.setStatus(520);
            responseStatus.setMsg("批量删除有误");
        }
        return responseStatus;
    }

}
