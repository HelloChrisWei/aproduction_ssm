package com.cskaoyan.controller.scheduling;

import com.cskaoyan.exception.CustomException;
import com.cskaoyan.pojo.Custom;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.scheduling.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/custom")
public class CustomController {

    @Autowired
    private CustomService customService;

    @RequestMapping("/list")
    @ResponseBody
    public EasyUiDataGridResult<Custom> custom(int page, int rows) {
        return customService.selectAllCustomByPage(page, rows);
    }

    @RequestMapping("/find")
    public String customList() {
        return "custom_list";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Custom> searchCustomData(){
        return customService.selectAllCustom();
    }

    @RequestMapping("/add_judge")
    public String customAddJudge() {
        return "custom_add";
    }

    @RequestMapping("/add")
    public String customAdd() {
        return "custom_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResponseStatus customInsert(Custom custom){
        return customService.insert(custom);
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public ResponseStatus editJudge(){
        return new ResponseStatus();
    }

    @RequestMapping("/edit")
    public String edit(){
        return "custom_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public ResponseStatus updateAll(Custom custom){
        return customService.updateByPrimaryKeySelective(custom);
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public ResponseStatus updateNote(Custom custom) {
        return customService.updateByPrimaryKeySelective(custom);
    }

    @RequestMapping("/delete_batch")
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

    @RequestMapping("/delete_judge")
    @ResponseBody
    public ResponseStatus deleteJudge(){
        return new ResponseStatus();
    }

    @RequestMapping("/search_custom_by_customId")
    @ResponseBody
    public EasyUiDataGridResult searchCustomByCustomId(String searchValue, int page, int rows){
        return customService.searchCustomByCustomId(searchValue,page,rows);
    }

    @RequestMapping("/search_custom_by_customName")
    @ResponseBody
    public EasyUiDataGridResult searchCustomByCustomName(String searchValue,int page, int rows){
        return customService.searchCustomByCustomName(searchValue,page,rows);
    }

    @RequestMapping("/get/{customId}")
    @ResponseBody
    public Custom searchCustomDetail(@PathVariable("customId") String customId){
        return customService.selectCustomByCustomId(customId);
    }

}
