package com.cskaoyan.controller.material;

import com.cskaoyan.exception.MaterialException;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Material;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @RequestMapping("/list")
    @ResponseBody
    public EasyUiDataGridResult<Material> material(int page, int rows) {
        return materialService.selectAllMaterialByPage(page, rows);
    }

    @RequestMapping("/find")
    public String materialList() {
        return "material_list";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Material> searchMaterialData() {
        return materialService.selectAllMaterial();
    }

    @RequestMapping("/add_judge")
    public String materialAddJudge() {
        return "material_add";
    }

    @RequestMapping("/add")
    public String materialAdd() {
        return "material_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResponseStatus materialInsert(Material material) {
        return materialService.insert(material);
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public ResponseStatus editJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("/edit")
    public String edit() {
        return "material_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public ResponseStatus updateAll(Material material) {
        return materialService.updateByPrimaryKeySelective(material);
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public ResponseStatus updateNote(Material material) {
        return materialService.updateByPrimaryKeySelective(material);
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatch(String[] ids) {
        try {
            return materialService.deleteBatch(ids);
        } catch (MaterialException e) {
            e.printStackTrace();
            ResponseStatus status = new ResponseStatus();
            status.setStatus(0);
            status.setMsg("删除物料失败！");
            return status;
        }
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public ResponseStatus deleteJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("/search_material_by_materialId")
    @ResponseBody
    public EasyUiDataGridResult searchMaterialByMaterialId(String searchValue, int page, int rows) {
        return materialService.searchMaterialByMaterialId(searchValue, page, rows);
    }

    @RequestMapping("/search_material_by_materialType")
    @ResponseBody
    public EasyUiDataGridResult searchMaterialByMaterialType(String searchValue, int page, int rows) {
        return materialService.searchMaterialByMaterialType(searchValue, page, rows);
    }

    @RequestMapping("/get/{materialId}")
    @ResponseBody
    public Material searchMaterialDetail(@PathVariable("materialId") String materialId) {
        return materialService.selectMaterialByMaterialId(materialId);
    }
}
