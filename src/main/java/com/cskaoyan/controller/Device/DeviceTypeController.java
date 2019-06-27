package com.cskaoyan.controller.Device;


import com.cskaoyan.pojo.DeviceType;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.DeviceService.ServiceImpl.DeviceTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceTypeController {
    @Autowired
    DeviceTypeServiceImpl deviceTypeService;
//-------------------------------------------
    //实现设备种类查询模块
    @RequestMapping("device/deviceType")
    public String deviceType() {
        return "deviceType";
    }

    @RequestMapping("deviceType/list")
    @ResponseBody
    public List<DeviceType> typelist() {
        List allDevice = deviceTypeService.findAllTypeDevice();
        return allDevice;
    }
    //------------------------------------------
    //实现种类界面新增功能
    @RequestMapping("deviceType/add_judge")
    public String add_judge(){
        return "deviceType_add";
    }
    @RequestMapping("deviceType/add")
    public String add(){
        return "deviceType_add";
    }
    @RequestMapping("deviceType/insert")
    @ResponseBody
    public ResponseStatus insert(DeviceType deviceType){
        return deviceTypeService.insertTypeDevice(deviceType);
    }

}
