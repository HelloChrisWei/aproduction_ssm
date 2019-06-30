package com.cskaoyan.controller.quality;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ProcessCountCheck;
import com.cskaoyan.pojo.ProcessCountCheck;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.quality.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @version 1.0 2019/6/29
 * @author Wei
 */
@Controller
public class ProcessCountCheckController {
    @Autowired
    ProcessCountCheckService processCountCheckService;
    
    /*#############页面跳转#############*/

    @RequestMapping(value = "/p_count_check/find", method = RequestMethod.GET)
    public String turnToListPage() {
        return "p_count_check_list";
    }

    @RequestMapping(value = "/p_count_check/add", method = RequestMethod.GET)
    public String turnToAddPage() {
        return "p_count_check_add";
    }


    @RequestMapping(value = "/p_count_check/edit", method = RequestMethod.GET)
    public String turnToEditPage() {
        return "p_count_check_edit";
    }

    /*#############权限判断#############*/

    /**
     * 更优雅的方式实现权限判断
     * @return
     */
    @RequestMapping(value = {"/pCountCheck/add_judge", "/pCountCheck/delete_judge", "/pCountCheck/edit_judge"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseStatus xxx_judge() {
        return new ResponseStatus();
    }

    
    /*#############查询业务代码#############*/
    @RequestMapping(value = "/p_count_check/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUiDataGridResult list(@RequestParam("page") int page, @RequestParam("rows") int rows) {
        return processCountCheckService.fetchAllItems(page, rows);
    }


    @RequestMapping(value = "/p_count_check/search_pCountCheck_by_pCountCheckId",method = RequestMethod.GET)
    @ResponseBody
    public EasyUiDataGridResult searchByPMeasureCheckId(@RequestParam("searchValue") String pCountCheckId, @RequestParam("page") int page, @RequestParam("rows") int rows) {
        return processCountCheckService.searchById(pCountCheckId, page, rows);
    }


    /*#############删除业务代码#############*/
    @RequestMapping(value = "/p_count_check/delete_batch",method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus deleteBatchByIds(@RequestParam("ids") String[] ids) {
        return processCountCheckService.deleteBatchByIds(ids);
    }


    /*#############修改业务代码#############*/
    @RequestMapping(value = "/p_count_check/update_all",method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus updateAll(ProcessCountCheck record) {
        return processCountCheckService.updateByPrimaryKey(record);
    }

    @RequestMapping(value = "/p_count_check/update_note",method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus updateNote(@RequestParam("pCountCheckId") String pCountCheckId, @RequestParam("note") String note) {
        ProcessCountCheck processCountCheck = new ProcessCountCheck();
        processCountCheck.setpCountCheckId(pCountCheckId);
        processCountCheck.setNote(note);

        return processCountCheckService.updateByPrimaryKeySelective(processCountCheck);
    }


    /*#############新增业务代码#############*/
    // TODO
    @RequestMapping(value = "/p_count_check/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus insert() {
        return null;
    }
}
