package com.cskaoyan.service.DeviceService;


import com.cskaoyan.pojo.DeviceCheck;
import com.cskaoyan.pojo.DeviceType;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface DeviceCheckService {
    public List<DeviceCheck> findDeviceCheck();
    public EasyUiDataGridResult<DeviceCheck> findAllDeviceCheck(int page, int rows);
    public ResponseStatus insertCheckDevice(DeviceCheck deviceCheck);
    public ResponseStatus deleteCheck(String[] ids);
    public ResponseStatus updateByPrimaryKeySelective(DeviceCheck deviceCheck);
    public EasyUiDataGridResult searchByCheckId(String searchValue, int page, int rows);
    public EasyUiDataGridResult searchByCheckName(String searchValue, int page, int rows);
}
