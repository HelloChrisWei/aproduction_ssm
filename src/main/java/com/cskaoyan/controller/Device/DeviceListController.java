package com.cskaoyan.controller.Device;


import com.cskaoyan.pojo.Device;
import com.cskaoyan.pojo.DeviceType;
import com.cskaoyan.service.DeviceService.ServiceImpl.DeviceListServiceImpl;
import com.cskaoyan.service.DeviceService.ServiceImpl.DeviceTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class DeviceListController {
    @Autowired
    DeviceListServiceImpl deviceListService;
    @Autowired
    DeviceTypeServiceImpl deviceTypeService;

    //-----------------------------------------------
    //要实现查询设备台账功能
    @RequestMapping("device/deviceList")
    public String deviceList() {
        return "deviceList";
    }

    @RequestMapping("deviceList/list")
    @ResponseBody
    public List<Device> Listlist() {
        List allDevice = deviceListService.findAllDeviceList();
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
        List allDevice = deviceTypeService.findAllTypeDevice();
        return allDevice;
    }
/*    @RequestMapping("employee/get_data")
    @ResponseBody
    public List<Employee> employeeId(){
        List<Employee> allEmployee = employeeService.findAllEmployee();
        return allEmployee;
    }*/



}
