package com.cskaoyan.controller.Device;

import com.cskaoyan.pojo.DeviceCheck;
import com.cskaoyan.pojo.DeviceMaintain;
import com.cskaoyan.pojo.DeviceType;
import com.cskaoyan.pojo.ResponseStatus;
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
    @RequestMapping("deviceCheck/get_data")
    @ResponseBody
    public List<DeviceCheck> deviceTypeId(){
        List allDevice = deviceCheckService.findAllDeviceCheck();
        return allDevice;
    }
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
    //------------------------------------------
    //实现例检界面新增功能
    @RequestMapping("deviceCheck/add_judge")
    public String add_judge() {
        return "forward:add";
    }

    @RequestMapping("deviceCheck/add")
    public String add() {
        return "deviceCheck_add";
    }

    @RequestMapping("deviceCheck/insert")
    @ResponseBody
    public ResponseStatus insert(DeviceCheck deviceCheck) {
        System.out.println(deviceCheck);
        return deviceCheckService.insertCheckDevice(deviceCheck);
    }
}
