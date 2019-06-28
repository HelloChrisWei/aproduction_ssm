package com.cskaoyan.controller.Device;

import com.cskaoyan.pojo.*;
import com.cskaoyan.service.DeviceService.ServiceImpl.DeviceCheckServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
        List allDevice = deviceCheckService.findDeviceCheck();
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
    public EasyUiDataGridResult checklist(int page,int rows) {
        return deviceCheckService.findAllDeviceCheck(page,rows);
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
        return deviceCheckService.insertCheckDevice(deviceCheck);
    }
    //-------------------------------------------------
    //种类界面实现删除功能
    @RequestMapping("deviceCheck/delete_judge")
    @ResponseBody
    public ResponseStatus deleteJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("deviceCheck/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatch(String[] ids) {
        return deviceCheckService.deleteCheck(ids);
    }

    //----------------------------------------------------
    //种类界面实现修改功能
    @RequestMapping("deviceCheck/edit_judge")
    public String edit_judge() {
        return "forward:edit";
    }

    @RequestMapping("deviceCheck/edit")
    public String editType() {
        return "deviceCheck_edit";
    }

    @RequestMapping("deviceCheck/update")
    @ResponseBody
    public ResponseStatus uodateType(DeviceCheck deviceCheck) {
        return deviceCheckService.updateByPrimaryKeySelective(deviceCheck);
    }
    //-----------------------------------------------
    //实现种类界面的查找功能
    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceCheckId")
    @ResponseBody
    public EasyUiDataGridResult searchByCheckId(String searchValue, int page, int rows) {
        EasyUiDataGridResult result = deviceCheckService.searchByCheckId(searchValue, page, rows);
        return result;
    }

    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceName")
    @ResponseBody
    public EasyUiDataGridResult searchByCheckName(String searchValue, int page, int rows) {
        EasyUiDataGridResult result = deviceCheckService.searchByCheckName(searchValue, page, rows);
        return result;
    }
}
