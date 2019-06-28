package com.cskaoyan.controller.Device;


import com.cskaoyan.exception.OrderException;
import com.cskaoyan.pojo.DeviceType;
import com.cskaoyan.pojo.DeviceType2;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.DeviceService.ServiceImpl.DeviceTypeServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DeviceTypeController {
    @Autowired
    DeviceTypeServiceImpl deviceTypeService;
//-------------------------------------------
    //实现设备种类查询模块
    @RequestMapping("device/deviceType")
    public String deviceType() {
        return "deviceType";
    }

    @RequestMapping("deviceType/list")
    @ResponseBody
    public List<DeviceType> typelist() {
        List allDevice = deviceTypeService.findAllTypeDevice();
        return allDevice;
    }
    //------------------------------------------
    //实现种类界面新增功能
    @RequestMapping("deviceType/add_judge")
    public String add_judge(){
        return "deviceType_add";
    }
    @RequestMapping("deviceType/add")
    public String add(){
        return "deviceType_add";
    }

    @RequestMapping("deviceType/insert")
    @ResponseBody
    public ResponseStatus insert(DeviceType2 d2){
        String deviceTypeWarranty = d2.getDeviceTypeWarranty();
        DeviceType d = new DeviceType();
        d.setDeviceTypeId(d2.getDeviceTypeId());
        d.setDeviceTypeModel(d2.getDeviceTypeModel());
        d.setDeviceTypeName(d2.getDeviceTypeName());
        d.setDeviceTypeProducer(d2.getDeviceTypeProducer());
        d.setDeviceTypeQuantity(d2.getDeviceTypeQuantity());
        d.setDeviceTypeSpec(d2.getDeviceTypeSpec());
        d.setDeviceTypeSupplier(d2.getDeviceTypeSupplier());
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            date= simpleDateFormat.parse(deviceTypeWarranty);
        }catch (Exception e){
            e.printStackTrace();
        }
        d.setDeviceTypeWarranty(date);
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
        try {
            return deviceTypeService.deleteType(ids);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseStatus status = new ResponseStatus();
            status.setStatus(0);
            status.setMsg("删除种类失败！");
            return status;
        }
    }
    }
