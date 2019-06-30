package com.cskaoyan.service.DeviceService;

import com.cskaoyan.pojo.DeviceType;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.pojo.Technology;

import java.util.List;

public interface DeviceTypeService {
    public List<DeviceType> findTypeDevice();
    public EasyUiDataGridResult<DeviceType> findAllTypeDevice(int page, int rows);
    public ResponseStatus insertTypeDevice(DeviceType deviceType);
    public ResponseStatus deleteType(String[] ids);
    public ResponseStatus updateByPrimaryKeySelective(DeviceType deviceType);
    public EasyUiDataGridResult searchByTypeId(String searchValue,int page,int rows);
    public EasyUiDataGridResult searchByTypeName(String searchValue,int page,int rows);
    public DeviceType searchTypeId(String searchValue);
}
