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
    public EasyUiDataGridResult<DeviceCheck> findAllDeviceCheck(int page, int rows) {
        PageHelper.startPage(page,rows);
        //创建EasyUiDataGridResult类，目的:封装list数据
        EasyUiDataGridResult<DeviceCheck> easyUiDataGridResult = new EasyUiDataGridResult<>();
        //目的:获取总条目数
        DeviceCheckExample deviceCheckExample = new DeviceCheckExample();
        //封装list
        easyUiDataGridResult.setRows( deviceCheckMapper.findAllDeviceCheck());
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
        EasyUiDataGridResult<DeviceCheck> result = new EasyUiDataGridResult<>();
        String checkid= "%"+CheckId+"%";
        List<DeviceCheck> deviceChecks = deviceCheckMapper.searchByCheckId(checkid);
        result.setRows(deviceChecks);
        result.setTotal(2);
        return result;
    }
    @Override
    public EasyUiDataGridResult searchByCheckName(String CheckName, int page, int rows) {
        EasyUiDataGridResult<DeviceCheck> result = new EasyUiDataGridResult<>();
        String checkname= "%"+CheckName+"%";
        List<DeviceCheck> deviceChecks = deviceCheckMapper.searchByCheckName(checkname);
        result.setRows(deviceChecks);
        result.setTotal(1);
        return result;
    }
}
