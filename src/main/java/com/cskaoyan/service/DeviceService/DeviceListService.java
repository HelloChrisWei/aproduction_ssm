package com.cskaoyan.service.DeviceService;

import com.cskaoyan.pojo.*;

import java.util.List;

public interface DeviceListService {
    public List<Device> findDeviceList();
    public EasyUiDataGridResult<DeviceVO> findAllDeviceList(int page, int rows);
    public ResponseStatus addList(Device device);
    public Device searchDeviceById(String deviceId);
    public ResponseStatus deleteDevice(String[] ids);
    public ResponseStatus updateByPrimaryKeySelective(Device device);
    public EasyUiDataGridResult SearchByDeviceId(String searchValue, int page, int rows);
    public EasyUiDataGridResult SearchBydeviceName(String searchValue, int page, int rows);
    public EasyUiDataGridResult SearchBydeviceTypeName(String searchValue, int page, int rows);
}
