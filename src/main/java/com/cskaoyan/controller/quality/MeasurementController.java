package com.cskaoyan.controller.quality;

import com.cskaoyan.pojo.*;


import com.cskaoyan.service.quality.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @version 1.0 2019/6/28
 * @author Wei
 */
@Controller
public class MeasurementController {
    @Autowired
    MeasurementService measurementService;

    /*#############页面跳转#############*/

    @RequestMapping(value = "/measure/find", method = RequestMethod.GET)
    public String turnToListPage() {
        return "measurement_list";
    }

    @RequestMapping(value = "/measure/add", method = RequestMethod.GET)
    public String turnToAddPage() {
        return "measurement_add";
    }


    @RequestMapping(value = "/measure/edit", method = RequestMethod.GET)
    public String turnToEditPage() {
        return "measurement_edit";
    }

    /*#############权限判断#############*/

    /**
     * 更优雅的方式实现权限判断
     * @return
     */
    @RequestMapping(value = {"/fMeasureCheck/add_judge", "/fMeasureCheck/delete_judge", "/fMeasureCheck/edit_judge"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseStatus xxx_judge() {
        return new ResponseStatus();
    }


    /*#############查询业务代码#############*/
    @RequestMapping(value = "/measure/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUiDataGridResult list(@RequestParam("page") int page, @RequestParam("rows") int rows) {
        return measurementService.fetchAllItems(page, rows);
    }


    @RequestMapping(value = "/measure/search_fMeasureCheck_by_fMeasureCheckId",method = RequestMethod.GET)
    @ResponseBody
    public EasyUiDataGridResult searchByPMeasureCheckId(@RequestParam("searchValue") String fMeasureCheckId, @RequestParam("page") int page, @RequestParam("rows") int rows) {
        return measurementService.searchById(fMeasureCheckId, page, rows);
    }

    @RequestMapping(value = "/measure/search_fMeasureCheck_by_orderId",method = RequestMethod.GET)
    @ResponseBody
    public EasyUiDataGridResult searchByOrderId(@RequestParam("searchValue") String orderId, @RequestParam("page") int page, @RequestParam("rows") int rows) {
        return measurementService.searchByOrderId(orderId, page, rows);
    }



    /*#############删除业务代码#############*/
    @RequestMapping(value = "/measure/delete_batch",method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus deleteBatchByIds(@RequestParam("ids") String[] ids) {
        return measurementService.deleteBatchByIds(ids);
    }


    /*#############修改业务代码#############*/
    @RequestMapping(value = "/measure/update_all",method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus updateAll(FinalMeasuretCheck record) {
        return measurementService.updateByPrimaryKey(record);
    }

    @RequestMapping(value = "/measure/update_note",method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus updateNote(@RequestParam("fMeasureCheckId") String fMeasureCheckId, @RequestParam("note") String note) {
        FinalMeasuretCheck finalMeasuretCheck = new FinalMeasuretCheck();
        finalMeasuretCheck.setfMeasureCheckId(fMeasureCheckId);
        finalMeasuretCheck.setNote(note);

        return measurementService.updateByPrimaryKeySelective(finalMeasuretCheck);
    }


    /*#############新增业务代码#############*/
    // TODO
    @RequestMapping(value = "/measure/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus insert() {
        return null;
    }

}
