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
    public EasyUiDataGridResult<DeviceMaintainVO> findAllDeviceMaintain(int page, int rows) {
        PageHelper.startPage(page,rows);
        //创建EasyUiDataGridResult类，目的:封装list数据
        EasyUiDataGridResult<DeviceMaintainVO> easyUiDataGridResult = new EasyUiDataGridResult<>();
        //目的:获取总条目数
        DeviceMaintainExample deviceMaintainExample = new DeviceMaintainExample();
        //封装list
        easyUiDataGridResult.setRows( deviceMaintainMapper.findDeviceMaintain());
        //获取总数
        easyUiDataGridResult.setTotal((int) deviceMaintainMapper.countByExample(deviceMaintainExample));
        return easyUiDataGridResult;
    }
    @Override
    public ResponseStatus insertMaintainDevice(DeviceMaintain deviceMaintain) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            int i = deviceMaintainMapper.insert(deviceMaintain);
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
    public ResponseStatus deleteMaintain(String[] ids) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            for (String id : ids) {
                deviceMaintainMapper.deleteByPrimaryKey(id);
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
    public ResponseStatus updateByPrimaryKeySelective(DeviceMaintain deviceMaintain) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            deviceMaintainMapper.updateByPrimaryKeySelective(deviceMaintain);
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
    public EasyUiDataGridResult searchByMaintainId(String maintainId, int page, int rows) {
        PageHelper.startPage(page,rows);
        //
        EasyUiDataGridResult<DeviceMaintainVO> easyUiDataGridResult = new EasyUiDataGridResult<>();
        String MaintainId= "%"+maintainId+"%";
        DeviceMaintainExample deviceMaintainExample = new DeviceMaintainExample();

        easyUiDataGridResult.setRows( deviceMaintainMapper.searchByMaintainId(MaintainId));

        easyUiDataGridResult.setTotal((int) deviceMaintainMapper.countByExample(deviceMaintainExample));
        return easyUiDataGridResult;
    }
    @Override
    public EasyUiDataGridResult searchByDeviceFaultId(String deviceFaultId, int page, int rows) {
        EasyUiDataGridResult<DeviceMaintainVO> result = new EasyUiDataGridResult<>();
        String DeviceFaultId= "%"+deviceFaultId+"%";
        result.setRows(deviceMaintainMapper.searchByDeviceFaultId(DeviceFaultId));
        DeviceMaintainExample deviceMaintainExample = new DeviceMaintainExample();
        result.setTotal((int) deviceMaintainMapper.countByExample(deviceMaintainExample));
        return result;
    }

}
