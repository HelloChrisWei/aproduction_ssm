package com.cskaoyan.controller.Device;

import com.cskaoyan.pojo.DeviceMaintain;
import com.cskaoyan.service.impl.DeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceMaintainController {
    @Autowired
    DeviceServiceImpl deviceService;

    //------------------------------------------------
    //要实现设备维修查询功能
    @RequestMapping("device/deviceMaintain")
    public String deviceMaintain() {
        return "deviceMaintain";
    }

    @RequestMapping("deviceMaintain/list")
    @ResponseBody
    public List<DeviceMaintain> Maintainlist() {
        List<DeviceMaintain> allDevice = deviceService.findAllDeviceMaintain();
        return allDevice;
    }


}
