package com.cskaoyan.controller.quality;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.pojo.UnqualifyApply;
import com.cskaoyan.pojo.FinalMeasuretCheckVO;
import com.cskaoyan.service.measurement.MeasurementService;

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
@RequestMapping("/measure")
public class MeasureController {
   /* @Autowired
    private MeasurementService measurementService;

    *//*-------------查询业务代码-----------------*//*
    @RequestMapping("/find")
    public String turnToMeasurementList() {
        return "measurement_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EasyUiDataGridResult list(@RequestParam("page") int page, @RequestParam("rows") int rows) {
        return measurementService.getMeasurementList(page, rows);
    }

    *//**
     * 按主键（成品计量质检编号）查询条目
     * @param unqualifyApplyId
     * @param page
     * @param rows
     * @return
     *//*
    @RequestMapping(value = "/search_fMeasureCheck_by_fMeasureCheckId",method = RequestMethod.GET)
    @ResponseBody
    public EasyUiDataGridResult searchById(@RequestParam("searchValue") String unqualifyApplyId, @RequestParam("page") int page, @RequestParam("rows") int rows) {
        return measurementService.searchById(unqualifyApplyId, page, rows);
    }

    *//**
     * 按orderId(订单编号)实现模糊查询
     * @param productName 产品名称
     * @param page
     * @param rows
     * @return
     *//*
    @RequestMapping(value = "/search_fMeasureCheck_by_orderId",method = RequestMethod.GET)
    @ResponseBody
    public EasyUiDataGridResult searchByProductName(@RequestParam("searchValue") String productName, @RequestParam("page") int page, @RequestParam("rows") int rows) {
        FinalMeasuretCheckVO FinalMeasuretCheckVOExample = new FinalMeasuretCheckVO();
        FinalMeasuretCheckVOExample.setProductName(productName);

        return measurementService.selectByExample(FinalMeasuretCheckVOExample, page, rows);
    }



    *//*插入业务代码*//*

    *//**
     * 权限控制 不处理 直接转发
     * @return
     *//*
    @RequestMapping("/add_judge")
    public String add_judge() {
        return "forward:/unqualify/add";
    }

    @RequestMapping("/add")
    public String turnToAddPage() {
        return "unqualify_add";
    }

    // TODO  人员get_data接口未实现  实现后做
//    @RequestMapping("/unqualify/insert")
//    @ResponseBody
//    public ResponseStatus insert() {
//        ResponseStatus status = new ResponseStatus();
//        measurementService.insert
//
//        try {
//            boolean result = unqualifyService.addUnqualifyItem(item);
//            if (result)
//                return new ResponseVo(200, "OK", "");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseVo(0, "该不合格品申请编号已经存在，请更换！", "");
//
//    }

    *//*删除业务代码*//*
    *//**
     * 权限控制 不处理 直接转发
     * @return
     *//*
    @RequestMapping("/delete_judge")
    @ResponseBody
    public ResponseStatus delete_judge() {
        return new ResponseStatus();
    }

    @RequestMapping(value = "/delete_batch", method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus deleteBatch(@RequestParam("ids") String[] ids) {
        boolean result = measurementService.deleteBatch(ids);
        if (result) {
            return new ResponseStatus(200, "OK", null, 0, null);
        }
        return new ResponseStatus(0, "Fail", null, 0, null);
    }


    *//*修改业务代码*//*
    *//**
     * 权限控制 不处理 直接转发
     * @return
     *//*
    @RequestMapping("/edit_judge")
    @ResponseBody
    public ResponseStatus edit_judge() {
        return new ResponseStatus();
    }

    @RequestMapping("/edit")
    public String turnToEditPage() {
        return "unqualify_edit";
    }

    *//**
     * 修改条目的单个项目：备注
     * @param unqualifyApplyId 待修改项目的主键
     * @param note 新备注
     * @return
     *//*
    @RequestMapping("/update_note")
    @ResponseBody
    public ResponseStatus updateNote(@RequestParam("unqualifyApplyId") String unqualifyApplyId, @RequestParam("note") String note) {
        UnqualifyApply unqualifyApply = new UnqualifyApply();
        unqualifyApply.setUnqualifyApplyId(unqualifyApplyId);
        unqualifyApply.setNote(note);

        return measurementService.updateByPrimaryKeySelective(unqualifyApply);
    }

    *//**
     * 修改条目的多个项目
     * @param record
     * @return
     *//*
    @RequestMapping("/update_all")
    @ResponseBody
    public ResponseStatus updateAll(UnqualifyApply record) {

        return measurementService.updateByPrimaryKey(record);
    }*/

}
