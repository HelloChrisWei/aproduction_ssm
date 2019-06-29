package com.cskaoyan.service.DeviceService.ServiceImpl;

import com.cskaoyan.mapper.DeviceFaultMapper;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.DeviceService.DeviceFaultService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    DeviceFaultMapper deviceFaultMapper;

    @Override
    public List<DeviceFault> findDeviceFault(){
        return deviceFaultMapper.findAllDeviceFault();
    }
    @Override
    public EasyUiDataGridResult<DeviceFault> findAllDeviceFault(int page, int rows) {
        PageHelper.startPage(page,rows);
        //创建EasyUiDataGridResult类，目的:封装list数据
        EasyUiDataGridResult<DeviceFault> easyUiDataGridResult = new EasyUiDataGridResult<>();
        //目的:获取总条目数
        DeviceFaultExample deviceFaultExample = new DeviceFaultExample();
        //封装list
        easyUiDataGridResult.setRows( deviceFaultMapper.findAllDeviceFault());
        //获取总数
        easyUiDataGridResult.setTotal((int) deviceFaultMapper.countByExample(deviceFaultExample));
        return easyUiDataGridResult;
    }
}
