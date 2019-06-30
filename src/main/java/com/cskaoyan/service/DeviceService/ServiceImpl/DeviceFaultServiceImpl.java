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
    public EasyUiDataGridResult<DeviceFaultVO> findAllDeviceFault(int page, int rows) {
        PageHelper.startPage(page,rows);
        //创建EasyUiDataGridResult类，目的:封装list数据
        EasyUiDataGridResult<DeviceFaultVO> easyUiDataGridResult = new EasyUiDataGridResult<>();
        //目的:获取总条目数
        DeviceFaultExample deviceFaultExample = new DeviceFaultExample();
        //封装list
        easyUiDataGridResult.setRows( deviceFaultMapper.findDeviceFault());
        //获取总数
        easyUiDataGridResult.setTotal((int) deviceFaultMapper.countByExample(deviceFaultExample));
        return easyUiDataGridResult;
    }
    @Override
    public ResponseStatus insertFaultDevice(DeviceFault deviceFault) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            int i = deviceFaultMapper.insert(deviceFault);
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
    public ResponseStatus deleteFault(String[] ids) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            for (String id : ids) {
                deviceFaultMapper.deleteByPrimaryKey(id);
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
    public ResponseStatus updateByPrimaryKeySelective(DeviceFault deviceFault) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            deviceFaultMapper.updateByPrimaryKeySelective(deviceFault);
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
    public EasyUiDataGridResult searchByFaultId(String FaultId, int page, int rows) {
        PageHelper.startPage(page,rows);
        EasyUiDataGridResult<DeviceFaultVO> easyUiDataGridResult = new EasyUiDataGridResult<>();
        String faultId= "%"+FaultId+"%";
        //目的:获取总条目数
        DeviceFaultExample deviceFaultExample = new DeviceFaultExample();
        //封装list
        easyUiDataGridResult.setRows( deviceFaultMapper.searchByFaultId(faultId));
        //获取总数
        easyUiDataGridResult.setTotal((int) deviceFaultMapper.countByExample(deviceFaultExample));
        return easyUiDataGridResult;
    }
    @Override
    public EasyUiDataGridResult searchByDeviceName(String DeviceName, int page, int rows) {
        PageHelper.startPage(page,rows);
        EasyUiDataGridResult<DeviceFaultVO> easyUiDataGridResult = new EasyUiDataGridResult<>();
        String deviceName= "%"+DeviceName+"%";
        //目的:获取总条目数
        DeviceFaultExample deviceFaultExample = new DeviceFaultExample();
        //封装list
        easyUiDataGridResult.setRows(deviceFaultMapper.searchByDeviceName(deviceName));
        //获取总数
        easyUiDataGridResult.setTotal((int) deviceFaultMapper.countByExample(deviceFaultExample));
        return easyUiDataGridResult;
    }
    @Override
    public DeviceFault searchFaultId(String searchValue) {
        DeviceFault deviceFault = deviceFaultMapper.selectByPrimaryKey(searchValue);
        return deviceFault;
    }
}
