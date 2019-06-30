package com.cskaoyan.service.DeviceService;

import com.cskaoyan.pojo.*;

import java.util.List;

public interface DeviceMaintainService {
    public List<DeviceMaintain> findDeviceMaintain();
    public EasyUiDataGridResult<DeviceMaintainVO> findAllDeviceMaintain(int page, int rows);
    public ResponseStatus insertMaintainDevice(DeviceMaintain deviceMaintain);
    public ResponseStatus deleteMaintain(String[] ids);
    public ResponseStatus updateByPrimaryKeySelective(DeviceMaintain deviceMaintain);
    public EasyUiDataGridResult searchByMaintainId(String searchValue, int page, int rows);
    public EasyUiDataGridResult searchByDeviceFaultId(String searchValue, int page, int rows);
}
