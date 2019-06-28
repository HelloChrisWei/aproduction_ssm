package com.cskaoyan.controller.quality;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.pojo.UnqualifyApplyVO;
import com.cskaoyan.service.quality.UnQualityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @version 1.0 2019/6/26
 * @author Wei
 */
@Controller
@RequestMapping("/unqualify")
public class QualityController {
    @Autowired
    private UnQualityService unQualityService;

    /*查询业务代码*/
    @RequestMapping("/find")
    public String turnToUnqualifyList() {
        return "unqualify_list";
    }


    @RequestMapping("/list")
    @ResponseBody
    public EasyUiDataGridResult list(@RequestParam("page") int page, @RequestParam("rows") int rows) {
        EasyUiDataGridResult<UnqualifyApplyVO> result = new EasyUiDataGridResult<>();

        List<UnqualifyApplyVO> list = unQualityService.getUnqualityList(page, rows);
        int total = unQualityService.getTotalRecordNum();

        result.setRows(list);
        result.setTotal(total);

        return result;
    }


    /*插入业务代码*/

    /**
     * 权限控制 不处理 直接转发
     * @return
     */
    @RequestMapping("/add_judge")
    public String add_judge() {
        return "forward:/unqualify/add";
    }


    @RequestMapping("/add")
    public String turnToAddPage() {
        return "unqualify_add";
    }

//    @RequestMapping("/unqualify/insert")
//    @ResponseBody
//    public ResponseStatus insert() {
//        ResponseStatus status = new ResponseStatus();
//        unQualityService.insert
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

    /*删除业务代码*/
    @RequestMapping("/delete_judge")
    @ResponseBody
    public ResponseStatus delete_judge() {
        return new ResponseStatus();
    }

    @RequestMapping(value = "/delete_batch", method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatus deleteBatch(@RequestParam("ids") String[] ids) {
        boolean result = unQualityService.deleteBatch(ids);
        if (result) {
            return new ResponseStatus(200, "OK", null, 0, null);
        }
        return new ResponseStatus(0, "Fail", null, 0, null);
    }





}
