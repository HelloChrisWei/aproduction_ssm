package com.cskaoyan.controller.Device;

import com.cskaoyan.pojo.DeviceFault;
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

    //--------------------------------------------------------
    //实现设备故障模块
    @RequestMapping("device/deviceFault")
    public String deviceFault() {
        return "deviceFault";
    }

    @RequestMapping("deviceFault/list")
    @ResponseBody
    public List<DeviceFault> faultlist() {
        List<DeviceFault> allDevice = deviceFaultService.findAllDeviceFault();
        return allDevice;
    }
}
