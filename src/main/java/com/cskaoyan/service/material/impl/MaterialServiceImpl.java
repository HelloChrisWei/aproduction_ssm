package com.cskaoyan.service.material.impl;

import com.cskaoyan.annotation.ProceedTime;
import com.cskaoyan.exception.MaterialException;
import com.cskaoyan.mapper.MaterialMapper;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    @Override
    @ProceedTime
    public EasyUiDataGridResult<Material> selectAllMaterialByPage(int page, int rows) {
        EasyUiDataGridResult<Material> result = new EasyUiDataGridResult<>();
        MaterialExample example = new MaterialExample();

        int total = (int) materialMapper.countByExample(example);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<Material> materials = materialMapper.selectAllMaterialByPage(rows, offset);
        result.setRows(materials);
        result.setTotal(total);
        return result;
    }

    @Override
    @ProceedTime
    public ResponseStatus insert(Material material) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isAdd = materialMapper.insertSelective(material);
            if (isAdd == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("该物料编号已存在，请更改物料编号，重新添加！");
        }
        return status;
    }

    @Override
    @ProceedTime
    public ResponseStatus updateByPrimaryKeySelective(Material material) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isUpdate = materialMapper.updateByPrimaryKeySelective(material);
            if (isUpdate == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("物料修改失败！请重试！");
        }
        return status;
    }

    @Override
    @ProceedTime
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResponseStatus deleteBatch(String[] ids) throws MaterialException {
        ResponseStatus status = new ResponseStatus();
        try {
            for (String id : ids) {
                materialMapper.deleteByPrimaryKey(id);
            }
            status.setStatus(200);
            status.setMsg("OK");
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("物料批量删除失败，请重试！");
            throw new MaterialException("物料批量删除失败，请重试！");
        }
        return status;
    }

    private EasyUiDataGridResult<Material> pageHandle(Material material, int rows, int page) {
        EasyUiDataGridResult<Material> result = new EasyUiDataGridResult<>();

        int total = materialMapper.selectMaterialCountByCondition(material);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<Material> materials = materialMapper.selectMaterialByConditionByPage(material, rows, offset);
        result.setRows(materials);
        result.setTotal(total);
        return result;
    }

    @Override
    @ProceedTime
    public EasyUiDataGridResult<Material> searchMaterialByMaterialId(String materialId, int page, int rows) {
        Material material = new Material();
        material.setMaterialId("%" + materialId + "%");
        return pageHandle(material, rows, page);
    }

    @Override
    @ProceedTime
    public EasyUiDataGridResult<Material> searchMaterialByMaterialType(String materialType, int page, int rows) {
        Material material = new Material();
        material.setMaterialType("%" + materialType + "%");
        return pageHandle(material, rows, page);
    }

    @Override
    @ProceedTime
    public Material selectMaterialByMaterialId(String materialId) {
        return materialMapper.selectByPrimaryKey(materialId);
    }

    @Override
    @ProceedTime
    public List<Material> selectAllMaterial() {
        return materialMapper.selectAllMaterial();
    }
}
