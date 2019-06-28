package com.cskaoyan.controller.Device;

import com.cskaoyan.pojo.DeviceCheck;
import com.cskaoyan.service.DeviceService.ServiceImpl.DeviceCheckServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceCheckController {
    @Autowired
    DeviceCheckServiceImpl deviceCheckService;
    //--------------------------------------------------------
    //实现设备例检功能
    @RequestMapping("device/deviceCheck")
    public String deviceCheck() {
        return "deviceCheck";
    }

    @RequestMapping("deviceCheck/list")
    @ResponseBody
    public List<DeviceCheck> checklist() {
        List<DeviceCheck> allDevice = deviceCheckService.findAllDeviceCheck();
        return allDevice;
    }
}
