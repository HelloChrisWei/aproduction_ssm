package com.cskaoyan.controller.scheduling;

import com.cskaoyan.exception.ManufactureException;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Manufacture;
import com.cskaoyan.pojo.ManufactureVO;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.scheduling.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {

    @Autowired
    private ManufactureService manufactureService;

    @RequestMapping("/list")
    @ResponseBody
    public EasyUiDataGridResult manufacture(int page, int rows) {
        return manufactureService.selectAllManufactureByPage(page, rows);
    }

    @RequestMapping("/find")
    public String manufactureList() {
        return "manufacture_list";
    }

    @RequestMapping("/add_judge")
    public String manufactureAddJudge() {
        return "manufacture_add";
    }

    @RequestMapping("/add")
    public String manufactureAdd() {
        return "manufacture_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResponseStatus manufactureInsert(Manufacture manufacture) {
        return manufactureService.insert(manufacture);
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public ResponseStatus editJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("/edit")
    public String edit() {
        return "manufacture_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public ResponseStatus updateAll(Manufacture manufacture) {
        return manufactureService.updateByPrimaryKeySelective(manufacture);
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public ResponseStatus updateNote(Manufacture manufacture) {
        return manufactureService.updateByPrimaryKeySelective(manufacture);
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatch(String[] ids) {
        try {
            return manufactureService.deleteBatch(ids);
        } catch (ManufactureException e) {
            e.printStackTrace();
            ResponseStatus status = new ResponseStatus();
            status.setStatus(0);
            status.setMsg("删除生产计划失败！");
            return status;
        }
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public ResponseStatus deleteJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("/search_manufacture_by_manufactureSn")
    @ResponseBody
    public EasyUiDataGridResult searchManufactureByManufactureSn(String manufactureSn,int page, int rows){
        return manufactureService.searchManufactureByManufactureSn(manufactureSn,page,rows);
    }

    @RequestMapping("/search_manufacture_by_manufactureOrderId")
    @ResponseBody
    public EasyUiDataGridResult searchManufactureByOrderId(String orderId,int page, int rows){
        return manufactureService.searchManufactureByOrderId(orderId,page,rows);
    }

    @RequestMapping("/search_manufacture_by_manufactureTechnologyName")
    @ResponseBody
    public EasyUiDataGridResult searchManufactureByTechnologyName(String technologyName, int page, int rows){
        return manufactureService.searchManufactureByTechnologyName(technologyName,page,rows);
    }

    @RequestMapping("/get/{manufactureSn}")
    @ResponseBody
    public ManufactureVO searchManufactureDetail(@PathVariable("manufactureSn") String manufactureSn){
        return manufactureService.selectManufactureByManufactureSn(manufactureSn);
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<ManufactureVO> searchManufactureData() {
        return manufactureService.selectAllManufacture();
    }
}
