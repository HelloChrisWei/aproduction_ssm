package com.cskaoyan.controller;

import com.cskaoyan.pojo.*;
import com.cskaoyan.service.impl.DeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DeviceController {
    @Autowired
    DeviceServiceImpl deviceService;
    //-----------------------------------------------
    //要实现查询设备台账功能
    @RequestMapping("device/deviceList")
    public String deviceList() {
        return "deviceList";
    }
    @RequestMapping("deviceList/list")
    @ResponseBody
    public List<Device> Listlist() {
        List allDevice = deviceService.findAllDeviceList();
        return allDevice;
    }
/*    @RequestMapping("eviceList/add_judge")
    public String add(){
    return "deviceList_add";
    }
     */


    //-----------------------------------------------
    //要实现查询设备种类功能
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

    //--------------------------------------------------
    //要实现设备例检功能
    @RequestMapping("device/deviceCheck")
    public String deviceCheck() {
        return "deviceCheck";
    }
    @RequestMapping("deviceCheck/list")
    @ResponseBody
    public List<DeviceCheck> checklist() {
        List<DeviceCheck>allDevice = deviceService.findAllDeviceCheck();
        return allDevice;
    }
    //------------------------------------------------
    //要实现设备故障查询功能
    @RequestMapping("device/deviceFault")
    public String deviceFault() {
        return "deviceFault";
    }
    @RequestMapping("deviceFault/list")
    @ResponseBody
    public List<DeviceFault> faultlist() {
        List<DeviceFault>allDevice = deviceService.findAllDeviceFault();
        return allDevice;
    }
    //------------------------------------------------
    //要实现设备维修查询功能
    @RequestMapping("device/deviceMaintain")
    public String deviceMaintain() {
        return "deviceMaintain";
    }
    @RequestMapping("deviceMaintain/list")
    @ResponseBody
    public List<DeviceMaintain> Maintainlist() {
        List<DeviceMaintain>allDevice = deviceService.findAllDeviceMaintain();
        return allDevice;
    }


    @RequestMapping("/homeinit")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home1");
        return modelAndView;
    }
}
