package com.cskaoyan.controller.Device;

import com.cskaoyan.pojo.DeviceCheck;
import com.cskaoyan.service.impl.DeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceCheckController {
    @Autowired
    DeviceServiceImpl deviceService;

    @RequestMapping("device/deviceCheck")
    public String deviceCheck() {
        return "deviceCheck";
    }

    @RequestMapping("deviceCheck/list")
    @ResponseBody
    public List<DeviceCheck> checklist() {
        List<DeviceCheck> allDevice = deviceService.findAllDeviceCheck();
        return allDevice;
    }
}
