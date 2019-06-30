package com.cskaoyan.controller.Device;


import com.cskaoyan.pojo.Device;
import com.cskaoyan.pojo.DeviceType;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
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
    public Device SearchDeviceDetail(@PathVariable("deviceId") String deviceId){
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
//    设备台账新增功能实现，，需要依赖其他模块
    @RequestMapping("deviceList/add_judge")
    public String add() {
        System.out.println("add-judge");
        return "deviceList_add";
    }
    @RequestMapping("deviceList/add")
    public String addtest() {
        return "deviceList_add";
    }//---这两步的目的都是获取到提交的表单
    @RequestMapping("deviceList/insert")
    @ResponseBody
    public ResponseStatus insert(Device d) {
        return deviceListService.addList(d);
    }
    //-------------------------------------------------
    //台账界面实现删除功能
    @RequestMapping("deviceList/delete_judge")
    @ResponseBody
    public ResponseStatus deleteJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("deviceList/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatch(String[] ids) {
        return deviceListService.deleteDevice(ids);
    }
    //----------------------------------------------------
    //台账界面实现修改功能
    @RequestMapping("deviceList/update_all")
    public String updateAll() {
        return "forward:update";
    }
    @RequestMapping("deviceList/update_note")
    public String updateNote() {
        return "forward:update";
    }
    @RequestMapping("deviceList/edit_judge")
    public String edit_judge() {
        return "forward:edit";
    }

    @RequestMapping("deviceList/edit")
    public String editType() {
        return "deviceList_edit";
    }

    @RequestMapping("deviceList/update")
    @ResponseBody
    public ResponseStatus updateDevice(Device device) {
        return deviceListService.updateByPrimaryKeySelective(device);
    }
    //-----------------------------------------------
    //实现台账界面的查找功能
    @RequestMapping("deviceList/search_device_by_deviceId")
    @ResponseBody
    public EasyUiDataGridResult SearchByDeviceId(String searchValue, int page, int rows) {
        EasyUiDataGridResult result = deviceListService.SearchByDeviceId(searchValue, page, rows);
        return result;
    }

    @RequestMapping("deviceList/search_device_by_deviceName")
    @ResponseBody
    public EasyUiDataGridResult SearchBydeviceName(String searchValue, int page, int rows) {
        EasyUiDataGridResult result = deviceListService.SearchBydeviceName(searchValue, page, rows);
        return result;
    }
    @RequestMapping("deviceList/search_device_by_deviceTypeName")
    @ResponseBody
    public EasyUiDataGridResult SearchBydeviceTypeName(String searchValue, int page, int rows) {
        EasyUiDataGridResult result = deviceListService.SearchBydeviceTypeName(searchValue, page, rows);
        return result;
    }

}
