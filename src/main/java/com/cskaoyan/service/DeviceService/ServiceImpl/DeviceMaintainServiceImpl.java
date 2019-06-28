package com.cskaoyan.service.DeviceService.ServiceImpl;

import com.cskaoyan.mapper.DeviceMaintainMapper;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.DeviceService.DeviceMaintainService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {
    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;

    @Override
    public List<DeviceMaintain> findDeviceMaintain(){
        return deviceMaintainMapper.findAllDeviceMaintain();
    }
    @Override
    public EasyUiDataGridResult<DeviceMaintain> findAllDeviceMaintain(int page, int rows) {
        PageHelper.startPage(page,rows);
        //创建EasyUiDataGridResult类，目的:封装list数据
        EasyUiDataGridResult<DeviceMaintain> easyUiDataGridResult = new EasyUiDataGridResult<>();
        //目的:获取总条目数
        DeviceMaintainExample deviceMaintainExample = new DeviceMaintainExample();
        //封装list
        easyUiDataGridResult.setRows( deviceMaintainMapper.findAllDeviceMaintain());
        //获取总数
        easyUiDataGridResult.setTotal((int) deviceMaintainMapper.countByExample(deviceMaintainExample));
        return easyUiDataGridResult;
    }

}
