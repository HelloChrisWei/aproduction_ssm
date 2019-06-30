package com.cskaoyan.controller.Device;


import com.cskaoyan.pojo.Device;
import com.cskaoyan.pojo.DeviceType;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.DeviceService.ServiceImpl.DeviceTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceTypeController {
    @Autowired
    DeviceTypeServiceImpl deviceTypeService;

    @RequestMapping("deviceType/get_data")
    @ResponseBody
    public List<DeviceType> deviceTypeId(){
        List allDevice = deviceTypeService.findTypeDevice();
        return allDevice;
    }
    @RequestMapping("deviceType/get/{deviceTypeId}")
    @ResponseBody
    public DeviceType SearchDeviceTypeDetail(@PathVariable("deviceTypeId") String deviceTypeId){
        return deviceTypeService.searchTypeId(deviceTypeId);
    }


    //-------------------------------------------
    //实现设备种类查询模块
    @RequestMapping("device/deviceType")
    public String deviceType() {
        return "deviceType";
    }

    @RequestMapping("deviceType/list")
    @ResponseBody
    public EasyUiDataGridResult typelist(int page,int rows) {
        return deviceTypeService.findAllTypeDevice(page, rows);
    }

    //------------------------------------------
    //实现种类界面新增功能
    @RequestMapping("deviceType/add_judge")
    public String add_judge() {
        return "deviceType_add";
    }

    @RequestMapping("deviceType/add")
    public String add() {
        return "deviceType_add";
    }

    @RequestMapping("deviceType/insert")
    @ResponseBody
    public ResponseStatus insert(DeviceType d) {
        return deviceTypeService.insertTypeDevice(d);
    }

    //-------------------------------------------------
    //种类界面实现删除功能
    @RequestMapping("deviceType/delete_judge")
    @ResponseBody
    public ResponseStatus deleteJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("deviceType/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatch(String[] ids) {
        return deviceTypeService.deleteType(ids);
    }

    //----------------------------------------------------
    //种类界面实现修改功能
    @RequestMapping("deviceType/update_all")
    public String updateAll() {
        return "forward:update";
    }
    @RequestMapping("deviceType/edit_judge")
    public String edit_judge() {
        return "forward:edit";
    }

    @RequestMapping("deviceType/edit")
    public String editType() {
        return "deviceType_edit";
    }

    @RequestMapping("deviceType/update")
    @ResponseBody
    public ResponseStatus updateType(DeviceType deviceType) {
        return deviceTypeService.updateByPrimaryKeySelective(deviceType);
    }

    //-----------------------------------------------
    //实现种类界面的查找功能
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public EasyUiDataGridResult searchByTypeId(String searchValue, int page, int rows) {
        EasyUiDataGridResult result = deviceTypeService.searchByTypeId(searchValue, page, rows);
        return result;
    }

    @RequestMapping("deviceType/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public EasyUiDataGridResult searchByTypeName(String searchValue, int page, int rows) {
        EasyUiDataGridResult result = deviceTypeService.searchByTypeName(searchValue, page, rows);
        return result;
    }
}
