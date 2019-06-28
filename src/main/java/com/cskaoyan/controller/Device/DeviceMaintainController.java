package com.cskaoyan.controller.Device;

import com.cskaoyan.pojo.Device;
import com.cskaoyan.pojo.DeviceMaintain;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.service.DeviceService.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceMaintainController {
    @Autowired
    DeviceMaintainService deviceMaintainService;
    @RequestMapping("deviceMaintain/get_data")
    @ResponseBody
    public List<DeviceMaintain> deviceTypeId(){
        List allDevice = deviceMaintainService.findDeviceMaintain();
        return allDevice;
    }

    //------------------------------------------------
    //实现设备维修查询功能
    @RequestMapping("device/deviceMaintain")
    public String deviceMaintain() {
        return "deviceMaintain";
    }

    @RequestMapping("deviceMaintain/list")
    @ResponseBody
    public EasyUiDataGridResult Maintainlist(int page,int rows) {
        return deviceMaintainService.findAllDeviceMaintain(page, rows);
    }


}
