package com.cskaoyan.service.DeviceService;

import com.cskaoyan.pojo.*;

import java.util.List;


public interface DeviceFaultService {
    public List<DeviceFault> findDeviceFault();

    public EasyUiDataGridResult<DeviceFaultVO> findAllDeviceFault(int page, int rows);

    public ResponseStatus insertFaultDevice(DeviceFault deviceFault);

    public ResponseStatus deleteFault(String[] ids);

    public ResponseStatus updateByPrimaryKeySelective(DeviceFault deviceFault);

    public EasyUiDataGridResult searchByFaultId(String searchValue, int page, int rows);

    public EasyUiDataGridResult searchByDeviceName(String FaultName, int page, int rows);

    public DeviceFault searchFaultId(String searchValue);
}
