package com.cskaoyan.controller.material;

import com.cskaoyan.exception.MaterialReceiveException;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.material.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/materialReceive")
public class MaterialReceiveController {

    @Autowired
    private MaterialReceiveService materialReceiveService;

    @RequestMapping("/list")
    @ResponseBody
    public EasyUiDataGridResult<MaterialReceiveVO> materialReceive(int page, int rows) {
        return materialReceiveService.selectAllMaterialReceiveByPage(page, rows);
    }

    @RequestMapping("/find")
    public String orderList() {
        return "materialReceive_list";
    }

    @RequestMapping("/add_judge")
    public String orderAddJudge() {
        return "materialReceive_add";
    }

    @RequestMapping("/add")
    public String orderAdd() {
        return "materialReceive_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResponseStatus orderInsert(MaterialReceive order) {
        return materialReceiveService.insert(order);
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public ResponseStatus editJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("/edit")
    public String edit() {
        return "materialReceive_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public ResponseStatus updateAll(MaterialReceive order) {
        return materialReceiveService.updateByPrimaryKeySelective(order);
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public ResponseStatus updateNote(MaterialReceive order) {
        return materialReceiveService.updateByPrimaryKeySelective(order);
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatch(String[] ids) {
        try {
            return materialReceiveService.deleteBatch(ids);
        } catch (MaterialReceiveException e) {
            e.printStackTrace();
            ResponseStatus status = new ResponseStatus();
            status.setStatus(0);
            status.setMsg("删除物料收入失败！");
            return status;
        }
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public ResponseStatus deleteJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("/search_materialReceive_by_receiveId")
    @ResponseBody
    public EasyUiDataGridResult<MaterialReceiveVO> searchMaterialReceiveByReceiveId(String searchValue,int page, int rows){
        return materialReceiveService.searchMaterialReceiveByReceiveId(searchValue,page,rows);
    }

    @RequestMapping("/search_materialReceive_by_materialId")
    @ResponseBody
    public EasyUiDataGridResult<MaterialReceiveVO> searchMaterialReceiveByMaterialId(String searchValue, int page, int rows){
        return materialReceiveService.searchMaterialReceiveByMaterialId(searchValue,page,rows);
    }

    @RequestMapping("/get/{receiveId}")
    @ResponseBody
    public MaterialReceiveVO searchMaterialReceiveDetail(@PathVariable("receiveId") String receiveId){
        return materialReceiveService.selectMaterialReceiveByReceiveId(receiveId);
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<MaterialReceiveVO> searchMaterialReceiveData(){
        return materialReceiveService.selectAllMaterialReceive();
    }
}
