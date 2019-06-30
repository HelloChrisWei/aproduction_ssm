package com.cskaoyan.controller.quality;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.FinalCountCheck;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.quality.CommonController;
import com.cskaoyan.service.quality.CommonService;
import com.cskaoyan.service.quality.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @version 1.0 2019/6/28
 * @author Wei
 */
@Controller
public class FinalCountCheckController {
    @Autowired
    FinalCountCheckService finalCountCheckService;

    /**
     * 更优雅的方式实现页面跳转
     * @param
     * @return
     */
//    @RequestMapping(value = "/{url}", method = RequestMethod.GET)
//    public String turnToPage2(@PathVariable String url) {
//        if ("find".equals(url)) {
//        return "f_count_check_list";
//        }
//        // TODO
//        // Bad smell: 不能这么写 拦截了所有的url 应该value用数组??
//        return "daf";
//    }

    /*#############页面跳转#############*/

    @RequestMapping(value = "/f_count_check/find", method = RequestMethod.GET)
    public String turnToListPage() {
//        if ("find".equals(url)) {
//            return "f_count_check_list";
//        }
        return "f_count_check_list";

//        return null;
    }

    @RequestMapping(value = "/f_count_check/add", method = RequestMethod.GET)
    public String turnToAddPage() {
        return "f_count_check_add";
    }


    @RequestMapping(value = "/f_count_check/edit", method = RequestMethod.GET)
    public String turnToEditPage() {
        return "f_count_check_edit";
    }

    /*#############权限判断#############*/

    /**
     * 更优雅的方式实现权限判断
     * @return
     */
    @RequestMapping(value = {"/fCountCheck/add_judge", "/fCountCheck/delete_judge", "/fCountCheck/edit_judge"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseStatus xxx_judge() {
        return new ResponseStatus();
    }


    /*#############查询业务代码#############*/
    @RequestMapping(value = "/f_count_check/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUiDataGridResult list(@RequestParam("page") int page, @RequestParam("rows") int rows) {
        return finalCountCheckService.fetchAllItems(page, rows);
    }



    /*search_fCountCheck_by_fCountCheckId?searchValue=df&page=1&rows=10*/
    @RequestMapping(value = "/f_count_check/search_fCountCheck_by_fCountCheckId",method = RequestMethod.GET)
    @ResponseBody
    public EasyUiDataGridResult searchByFCountCheckId(@RequestParam("searchValue") String fCountCheckId, @RequestParam("page") int page, @RequestParam("rows") int rows) {
        return finalCountCheckService.searchById(fCountCheckId, page, rows);
    }


//    http://192.168.2.100:8080/erp/f_count_check/search_fCountCheck_by_orderId?searchValue=d&page=1&rows=10
    @RequestMapping(value = "/f_count_check/search_fCountCheck_by_orderId",method = RequestMethod.GET)
    @ResponseBody
    public EasyUiDataGridResult searchByOrderId(@RequestParam("searchValue") String orderId, @RequestParam("page") int page, @RequestParam("rows") int rows) {
        return finalCountCheckService.searchByOrderId(orderId, page, rows);
    }



    /*#############删除业务代码#############*/
    @RequestMapping(value = "/f_count_check/delete_batch",method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus deleteBatchByIds(@RequestParam("ids") String[] ids) {
        return finalCountCheckService.deleteBatchByIds(ids);
    }


    /*#############修改业务代码#############*/
    @RequestMapping(value = "/f_count_check/update_all",method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus updateAll(FinalCountCheck record) {
        return finalCountCheckService.updateByPrimaryKey(record);
    }

    @RequestMapping(value = "/f_count_check/update_note",method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus updateNote(@RequestParam("fCountCheckId") String fCountCheckId, @RequestParam("note") String note) {
        FinalCountCheck finalCountCheck = new FinalCountCheck();
        finalCountCheck.setfCountCheckId(fCountCheckId);
        finalCountCheck.setNote(note);

        return finalCountCheckService.updateByPrimaryKeySelective(finalCountCheck);
    }




    /*#############新增业务代码#############*/
    // TODO
    @RequestMapping(value = "/f_count_check/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus insert() {
        return null;
    }

}
