package com.cskaoyan.controller.Device;

import com.cskaoyan.pojo.DeviceType;
import com.cskaoyan.service.impl.DeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceTypeController {
    @Autowired
    DeviceServiceImpl deviceService;

    @RequestMapping("device/deviceType")
    public String deviceType() {
        return "deviceType";
    }

    @RequestMapping("deviceType/list")
    @ResponseBody
    public List<DeviceType> typelist() {
        List allDevice = deviceService.findAllDevice();
        return allDevice;
    }

}
