package com.cskaoyan.controller.quality;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ProcessMeasureCheck;
import com.cskaoyan.pojo.ProcessMeasureCheck;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.quality.ProcessMeasureCheckService;

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
public class ProcessMeasureCheckController {
    @Autowired
    ProcessMeasureCheckService processMeasureCheckService;


    /*#############页面跳转#############*/

    @RequestMapping(value = "/p_measure_check/find", method = RequestMethod.GET)
    public String turnToListPage() {
//        if ("find".equals(url)) {
//            return "p_measure_check_list";
//        }
        return "p_measure_check_list";

//        return null;
    }

    @RequestMapping(value = "/p_measure_check/add", method = RequestMethod.GET)
    public String turnToAddPage() {
        return "p_measure_check_add";
    }


    @RequestMapping(value = "/p_measure_check/edit", method = RequestMethod.GET)
    public String turnToEditPage() {
        return "p_measure_check_edit";
    }

    /*#############权限判断#############*/

    /**
     * 更优雅的方式实现权限判断
     * @return
     */
    @RequestMapping(value = {"/pMeasureCheck/add_judge", "/pMeasureCheck/delete_judge", "/pMeasureCheck/edit_judge"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseStatus xxx_judge() {
        return new ResponseStatus();
    }


    /*#############查询业务代码#############*/
    @RequestMapping(value = "/p_measure_check/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUiDataGridResult list(@RequestParam("page") int page, @RequestParam("rows") int rows) {
        return processMeasureCheckService.fetchAllItems(page, rows);
    }


    @RequestMapping(value = "/p_measure_check/search_pMeasureCheck_by_pMeasureCheckId",method = RequestMethod.GET)
    @ResponseBody
    public EasyUiDataGridResult searchByPMeasureCheckId(@RequestParam("searchValue") String pMeasureCheckId, @RequestParam("page") int page, @RequestParam("rows") int rows) {
        return processMeasureCheckService.searchById(pMeasureCheckId, page, rows);
    }


    /*#############删除业务代码#############*/
    @RequestMapping(value = "/p_measure_check/delete_batch",method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus deleteBatchByIds(@RequestParam("ids") String[] ids) {
        return processMeasureCheckService.deleteBatchByIds(ids);
    }


    /*#############修改业务代码#############*/
    @RequestMapping(value = "/p_measure_check/update_all",method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus updateAll(ProcessMeasureCheck record) {
        return processMeasureCheckService.updateByPrimaryKey(record);
    }

    @RequestMapping(value = "/p_measure_check/update_note",method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus updateNote(@RequestParam("pMeasureCheckId") String pMeasureCheckId, @RequestParam("note") String note) {
        ProcessMeasureCheck processMeasureCheck = new ProcessMeasureCheck();
        processMeasureCheck.setpMeasureCheckId(pMeasureCheckId);
        processMeasureCheck.setNote(note);

        return processMeasureCheckService.updateByPrimaryKeySelective(processMeasureCheck);
    }


    /*#############新增业务代码#############*/
    // TODO
    @RequestMapping(value = "/p_measure_check/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus insert(ProcessMeasureCheck record) {
        return processMeasureCheckService.insert(record);
    }
}
