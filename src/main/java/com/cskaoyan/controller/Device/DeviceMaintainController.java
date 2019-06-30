package com.cskaoyan.controller.Device;

import com.cskaoyan.pojo.*;
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
    //------------------------------------------
    //实现维修界面新增功能
    @RequestMapping("deviceMaintain/add_judge")
    public String add_judge() {
        return "deviceMaintain_add";
    }

    @RequestMapping("deviceMaintain/add")
    public String add() {
        return "deviceMaintain_add";
    }

    @RequestMapping("deviceMaintain/insert")
    @ResponseBody
    public ResponseStatus insert(DeviceMaintain d) {
        return deviceMaintainService.insertMaintainDevice(d);
    }
    //-------------------------------------------------
    //种类界面实现删除功能
    @RequestMapping("deviceMaintain/delete_judge")
    @ResponseBody
    public ResponseStatus deleteJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("deviceMaintain/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatch(String[] ids) {
        return deviceMaintainService.deleteMaintain(ids);
    }
    //----------------------------------------------------
    //种类界面实现修改功能
    @RequestMapping("deviceMaintain/update_all")
    public String updateAll() {
        return "forward:update";
    }
    @RequestMapping("deviceMaintain/update_note")
    public String updateNote() {
        return "forward:update";
    }
    @RequestMapping("deviceMaintain/edit_judge")
    public String edit_judge() {
        return "forward:edit";
    }

    @RequestMapping("deviceMaintain/edit")
    public String editType() {
        return "deviceMaintain_edit";
    }

    @RequestMapping("deviceMaintain/update")
    @ResponseBody
    public ResponseStatus deviceMaintain(DeviceMaintain deviceMaintain) {
        return deviceMaintainService.updateByPrimaryKeySelective(deviceMaintain);
    }
    //-----------------------------------------------
    //实现种类界面的查找功能
    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public EasyUiDataGridResult searchByMaintainId(String searchValue, int page, int rows) {
        EasyUiDataGridResult result = deviceMaintainService.searchByMaintainId(searchValue, page, rows);
        return result;
    }

    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public EasyUiDataGridResult searchByDeviceFaultId(String searchValue, int page, int rows) {
        EasyUiDataGridResult result = deviceMaintainService.searchByDeviceFaultId(searchValue, page, rows);
        return result;
    }


}
