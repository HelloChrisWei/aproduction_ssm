package com.cskaoyan.controller.Device;

import com.cskaoyan.pojo.*;
import com.cskaoyan.service.DeviceService.ServiceImpl.DeviceFaultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceFaultController {

    @Autowired
    DeviceFaultServiceImpl deviceFaultService;
    @RequestMapping("deviceFault/get_data")
    @ResponseBody
    public List<DeviceFault> deviceTypeId(){
        List allDevice = deviceFaultService.findDeviceFault();
        return allDevice;
    }

    @RequestMapping("deviceFault/get/{deviceFaultId}")
    @ResponseBody
    public DeviceFault SearchDeviceTypeDetail(@PathVariable("deviceFaultId") String deviceFaultId){
        return deviceFaultService.searchFaultId(deviceFaultId);
    }

    //--------------------------------------------------------
    //实现设备故障模块
    @RequestMapping("device/deviceFault")
    public String deviceFault() {
        return "deviceFault";
    }

    @RequestMapping("deviceFault/list")
    @ResponseBody
    public EasyUiDataGridResult faultlist(int page, int rows) {
        return deviceFaultService.findAllDeviceFault(page, rows);
    }
    //------------------------------------------
    //实现故障界面新增功能
    @RequestMapping("deviceFault/add_judge")
    public String add_judge() {
        return "forward:add";
    }

    @RequestMapping("deviceFault/add")
    public String add() {
        return "deviceFault_add";
    }

    @RequestMapping("deviceFault/insert")
    @ResponseBody
    public ResponseStatus insert(DeviceFault deviceFault) {
        return deviceFaultService.insertFaultDevice(deviceFault);
    }
    //-------------------------------------------------
    //故障界面实现删除功能
    @RequestMapping("deviceFault/delete_judge")
    @ResponseBody
    public ResponseStatus deleteJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("deviceFault/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatch(String[] ids) {
        return deviceFaultService.deleteFault(ids);
    }
    //----------------------------------------------------
    //故障界面实现修改功能
    @RequestMapping("deviceFault/update_all")
    public String updateAll() {
        return "forward:update";
    }
    @RequestMapping("deviceFault/update_note")
    public String updateNote() {
        return "forward:update";
    }

    @RequestMapping("deviceFault/edit_judge")
    public String edit_judge() {
        return "forward:edit";
    }

    @RequestMapping("deviceFault/edit")
    public String editType() {
        return "deviceFault_edit";
    }

    @RequestMapping("deviceFault/update")
    @ResponseBody
    public ResponseStatus updateFault(DeviceFault deviceFault) {
        return deviceFaultService.updateByPrimaryKeySelective(deviceFault);
    }
    //-----------------------------------------------
    //实现故障界面的查找功能
    @RequestMapping("deviceFault/search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public EasyUiDataGridResult searchByFaultId(String searchValue, int page, int rows) {
        EasyUiDataGridResult result = deviceFaultService.searchByFaultId(searchValue, page, rows);
        return result;
    }

    @RequestMapping("deviceFault/search_deviceFault_by_deviceName")
    @ResponseBody
    public EasyUiDataGridResult searchByDeviceName(String searchValue, int page, int rows) {
        EasyUiDataGridResult result = deviceFaultService.searchByDeviceName(searchValue, page, rows);
        return result;
    }
}
