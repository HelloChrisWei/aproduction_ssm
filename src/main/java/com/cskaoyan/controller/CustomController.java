package com.cskaoyan.controller;

import com.cskaoyan.exception.CustomException;
import com.cskaoyan.pojo.Custom;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/custom")
public class CustomController {

    @Autowired
    private CustomService customService;

    @RequestMapping("/home")
    public ModelAndView findHome() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }

    @RequestMapping("/custom/list")
    @ResponseBody
    public EasyUiDataGridResult<Custom> custom(int page, int rows) {
        return customService.selectAllCustomByPage(page, rows);
    }

    @RequestMapping("/custom/find")
    public String customList() {
        return "custom_list";
    }

    @RequestMapping("/custom/get_data")
    @ResponseBody
    public List<Custom> searchCustomData(){
        return customService.selectAllCustom();
    }

    @RequestMapping("/custom/add_judge")
    public String customAddJudge() {
        return "custom_add";
    }

    @RequestMapping("/custom/add")
    public String customAdd() {
        return "custom_add";
    }

    @RequestMapping("/custom/insert")
    @ResponseBody
    public ResponseStatus customInsert(Custom custom){
        return customService.insert(custom);
    }

    @RequestMapping("/custom/edit_judge")
    @ResponseBody
    public ResponseStatus editJudge(){
        return new ResponseStatus();
    }

    @RequestMapping("/custom/edit")
    public String edit(){
        return "custom_edit";
    }

    @RequestMapping("/custom/update_all")
    @ResponseBody
    public ResponseStatus updateAll(Custom custom){
        return customService.updateByPrimaryKeySelective(custom);
    }
    //update_note
//    public ResponseStatus updateNote()

    @RequestMapping("/custom/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatch(String[] ids){
        try {
            return customService.deleteBatch(ids);
        } catch (CustomException e) {
            e.printStackTrace();
            ResponseStatus status = new ResponseStatus();
            status.setStatus(0);
            status.setMsg("删除客户失败！");
            return status;
        }
    }

    @RequestMapping("/custom/delete_judge")
    @ResponseBody
    public ResponseStatus deleteJudge(){
        return new ResponseStatus();
    }

    @RequestMapping("/custom/search_custom_by_customId")
    @ResponseBody
    public EasyUiDataGridResult searchCustomByCustomId(String searchValue, int page, int rows){
        return customService.searchCustomByCustomId(searchValue,page,rows);
    }

    @RequestMapping("/custom/search_custom_by_customName")
    @ResponseBody
    public EasyUiDataGridResult searchCustomByCustomName(String searchValue,int page, int rows){
        return customService.searchCustomByCustomName(searchValue,page,rows);
    }

    @RequestMapping("/custom/get/{customId}")
    @ResponseBody
    public Custom searchCustomDetail(@PathVariable("customId") String customId){
        return customService.selectCustomByCustomId(customId);
    }

}
