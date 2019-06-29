package com.cskaoyan.service.DeviceService;

import com.cskaoyan.pojo.Device;
import com.cskaoyan.pojo.DeviceVO;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;

import java.util.List;

public interface DeviceListService {
    public List<Device> findDeviceList();
    public EasyUiDataGridResult<DeviceVO> findAllDeviceList(int page, int rows);
    public ResponseStatus addList(Device device);
    public Device searchDeviceById(String deviceId);
    public ResponseStatus deleteDevice(String[] ids);
}
