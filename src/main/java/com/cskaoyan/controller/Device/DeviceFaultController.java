package com.cskaoyan.controller.Device;

import com.cskaoyan.pojo.Device;
import com.cskaoyan.pojo.DeviceFault;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.service.DeviceService.ServiceImpl.DeviceFaultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceFaultController {

    @Autowired
    DeviceFaultServiceImpl deviceFaultService;
    @RequestMapping("deviceFault/get_data")
    @ResponseBody
    public List<DeviceFault> deviceTypeId(){
        List allDevice = deviceFaultService.findDeviceFault();
        return allDevice;
    }

    //--------------------------------------------------------
    //实现设备故障模块
    @RequestMapping("device/deviceFault")
    public String deviceFault() {
        return "deviceFault";
    }

    @RequestMapping("deviceFault/list")
    @ResponseBody
    public EasyUiDataGridResult faultlist(int page, int rows) {
        return deviceFaultService.findAllDeviceFault(page, rows);
    }
}
