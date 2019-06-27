package com.cskaoyan.controller.Device;

import com.cskaoyan.controller.EmployeeController;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.impl.DeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class DeviceListController {
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

    //------------------------------------------------
//    设备台账新增功能实现
    @RequestMapping("deviceList/add_judge")
    public String add() {
        System.out.println("add-judge");
        return "deviceList_add";
    }
    @RequestMapping("deviceList/add")
    public String addtest() {
//        int i =deviceService.addList(device);
        System.out.println("addtest");
        return "deviceList_add";
    }//---这两步的目的都是获取到提交的表单
    //------这一步获取设备种类，通过json返回到页面，通过调用下面那显示种类管理获得方法
    // 同理获取保管人信息可以通过其他人的方法，用来返回全部的保管人员
    @RequestMapping("deviceType/get_data")
    @ResponseBody
    public List<DeviceType> deviceTypeId(){
        return new DeviceTypeController().typelist();
    }
    @RequestMapping("employee/get_data")
    @ResponseBody
    public List<Employee> employeeId(){
        List<Employee> list = new EmployeeController().list();
        return list;
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
        List<DeviceMaintain> allDevice = deviceService.findAllDeviceMaintain();
        return allDevice;
    }

}
