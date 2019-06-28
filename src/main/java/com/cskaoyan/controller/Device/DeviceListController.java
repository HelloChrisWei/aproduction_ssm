package com.cskaoyan.controller.Device;


import com.cskaoyan.pojo.Device;
import com.cskaoyan.pojo.DeviceType;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.service.DeviceService.ServiceImpl.DeviceListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class DeviceListController {
    @Autowired
    DeviceListServiceImpl deviceListService;
    @RequestMapping("deviceList/get_data")
    @ResponseBody
    public List<Device> deviceTypeId(){
        List allDevice = deviceListService.findDeviceList();
        return allDevice;
    }
    @RequestMapping("deviceList/get/{deviceId}")
    @ResponseBody
    public Device SsearchDeviceDetail(@PathVariable("deviceId") String deviceId){
        return deviceListService.searchDeviceById(deviceId);
    }


    //-----------------------------------------------
    //要实现查询设备台账功能
    @RequestMapping("device/deviceList")
    public String deviceList() {
        return "deviceList";
    }

    @RequestMapping("deviceList/list")
    @ResponseBody
    public EasyUiDataGridResult Listlist(int page,int rows) {
        return deviceListService.findAllDeviceList(page, rows);
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

/*    @RequestMapping("employee/get_data")
    @ResponseBody
    public List<Employee> employeeId(){
        List<Employee> allEmployee = employeeService.findAllEmployee();
        return allEmployee;
    }*/



}
