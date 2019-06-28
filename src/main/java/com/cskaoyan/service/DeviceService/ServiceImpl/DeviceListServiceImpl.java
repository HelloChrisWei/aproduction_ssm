package com.cskaoyan.service.DeviceService.ServiceImpl;

import com.cskaoyan.mapper.DeviceMapper;
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

    @Override
    public List<Device> findDeviceList(){
        return deviceListMapper.findAllDeviceList();
    }
    @Override
    public EasyUiDataGridResult<Device> findAllDeviceList(int page, int rows) {
        PageHelper.startPage(page,rows);
        //创建EasyUiDataGridResult类，目的:封装list数据
        EasyUiDataGridResult<Device> easyUiDataGridResult = new EasyUiDataGridResult<>();
        //目的:获取总条目数
        DeviceExample deviceExample = new DeviceExample();
        //封装list
        easyUiDataGridResult.setRows( deviceListMapper.findAllDeviceList());
        //获取总数
        easyUiDataGridResult.setTotal((int) deviceListMapper.countByExample(deviceExample));
        return easyUiDataGridResult;
    }

    @Override
    public Device searchDeviceById(String deviceId) {
        return deviceListMapper.selectByPrimaryKey(deviceId);
    }

    @Override
    public int addList(Device device) {
        int i = deviceListMapper.addList(device);
        return i;
    }

}
