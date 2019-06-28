package com.cskaoyan.service.DeviceService;


import com.cskaoyan.pojo.DeviceCheck;
import com.cskaoyan.pojo.DeviceType;
import com.cskaoyan.pojo.ResponseStatus;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface DeviceCheckService {
    public List findAllDeviceCheck();
    public ResponseStatus insertCheckDevice(DeviceCheck deviceCheck);
}
