package com.cskaoyan.service.DeviceService.ServiceImpl;


import com.cskaoyan.mapper.*;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.DeviceService.DeviceCheckService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {

    @Autowired
    DeviceCheckMapper deviceCheckMapper;
    @Override
    public List<DeviceCheck> findDeviceCheck(){
        return deviceCheckMapper.findAllDeviceCheck();
    }
    @Override
    public EasyUiDataGridResult<DeviceCheckVO> findAllDeviceCheck(int page, int rows) {
        PageHelper.startPage(page,rows);
        //创建EasyUiDataGridResult类，目的:封装list数据
        EasyUiDataGridResult<DeviceCheckVO> easyUiDataGridResult = new EasyUiDataGridResult<>();
        //目的:获取总条目数
        DeviceCheckExample deviceCheckExample = new DeviceCheckExample();
        //封装list
        easyUiDataGridResult.setRows( deviceCheckMapper.findDeviceCheck());
        //获取总数
        easyUiDataGridResult.setTotal((int) deviceCheckMapper.countByExample(deviceCheckExample));
        return easyUiDataGridResult;
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

    @Override
    public ResponseStatus deleteCheck(String[] ids) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            for (String id : ids) {
                deviceCheckMapper.deleteByPrimaryKey(id);
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
    @Override
    public ResponseStatus updateByPrimaryKeySelective(DeviceCheck deviceCheck) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            deviceCheckMapper.updateByPrimaryKeySelective(deviceCheck);
            responseStatus.setStatus(200);
            responseStatus.setMsg("OK");
        } catch (Exception e) {
            e.printStackTrace();
            responseStatus.setStatus(520);
            responseStatus.setMsg("无法插入");
        }

        return responseStatus;
    }
    @Override
    public EasyUiDataGridResult searchByCheckId(String CheckId, int page, int rows) {
        PageHelper.startPage(page,rows);
        EasyUiDataGridResult<DeviceCheckVO> easyUiDataGridResult = new EasyUiDataGridResult<>();
        String checkid= "%"+CheckId+"%";
        //目的:获取总条目数
        DeviceCheckExample deviceCheckExample = new DeviceCheckExample();
        //封装list
        easyUiDataGridResult.setRows( deviceCheckMapper.searchByCheckId(checkid));
        //获取总数
        easyUiDataGridResult.setTotal((int) deviceCheckMapper.countByExample(deviceCheckExample));
        return easyUiDataGridResult;
    }
    @Override
    public EasyUiDataGridResult searchByCheckName(String CheckName, int page, int rows) {
        PageHelper.startPage(page,rows);
        EasyUiDataGridResult<DeviceCheckVO> easyUiDataGridResult = new EasyUiDataGridResult<>();
        String checkname= "%"+CheckName+"%";
        //目的:获取总条目数
        DeviceCheckExample deviceCheckExample = new DeviceCheckExample();
        //封装list
        easyUiDataGridResult.setRows(deviceCheckMapper.searchByCheckName(checkname));
        //获取总数
        easyUiDataGridResult.setTotal((int) deviceCheckMapper.countByExample(deviceCheckExample));
        return easyUiDataGridResult;
    }
    @Override
    public DeviceCheck searchCheckId(String searchValue) {
        DeviceCheck deviceCheck = deviceCheckMapper.searchCheckId(searchValue);
        return deviceCheck;
    }
}
