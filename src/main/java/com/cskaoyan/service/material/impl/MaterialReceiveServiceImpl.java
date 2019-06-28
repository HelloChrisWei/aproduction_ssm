package com.cskaoyan.service.material.impl;

import com.cskaoyan.annotation.ProceedTime;
import com.cskaoyan.exception.MaterialReceiveException;
import com.cskaoyan.exception.OrderException;
import com.cskaoyan.mapper.MaterialReceiveMapper;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.material.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {
    
    @Autowired
    private MaterialReceiveMapper materialReceiveMapper;
    
    @Override
    @ProceedTime
    public EasyUiDataGridResult<MaterialReceiveVO> selectAllMaterialReceiveByPage(int page, int rows) {
        EasyUiDataGridResult<MaterialReceiveVO> result = new EasyUiDataGridResult<>();
        MaterialReceiveExample example = new MaterialReceiveExample();

        int total = (int) materialReceiveMapper.countByExample(example);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<MaterialReceiveVO> materialReceives = materialReceiveMapper.selectAllMaterialReceiveByPage(rows, offset);
        result.setRows(materialReceives);
        result.setTotal(total);
        return result;
    }

    @Override
    @ProceedTime
    public ResponseStatus insert(MaterialReceive materialReceive) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isAdd = materialReceiveMapper.insertSelective(materialReceive);
            if (isAdd == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("该物料收入已存在，请更改物料收入编号，重新添加！");
        }
        return status;
    }

    @Override
    @ProceedTime
    public ResponseStatus updateByPrimaryKeySelective(MaterialReceive materialReceive) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isUpdate = materialReceiveMapper.updateByPrimaryKeySelective(materialReceive);
            if (isUpdate == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("物料收入修改失败！请重试！");
        }
        return status;
    }

    @Override
    @ProceedTime
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResponseStatus deleteBatch(String[] ids) throws MaterialReceiveException {
        ResponseStatus status = new ResponseStatus();
        try {
            for (String id : ids) {
                materialReceiveMapper.deleteByPrimaryKey(id);
            }
            status.setStatus(200);
            status.setMsg("OK");
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("物料收入批量删除失败，请重试！");
            throw new MaterialReceiveException("物料收入批量删除失败，请重试！");
        }
        return status;
    }

    private EasyUiDataGridResult<MaterialReceiveVO> pageHandle(MaterialReceiveVO materialReceive, int rows, int page) {
        EasyUiDataGridResult<MaterialReceiveVO> result = new EasyUiDataGridResult<>();

        int total = materialReceiveMapper.selectMaterialReceiveCountByCondition(materialReceive);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<MaterialReceiveVO> materialReceives = materialReceiveMapper.selectMaterialReceiveByConditionByPage(materialReceive, rows, offset);
        result.setRows(materialReceives);
        result.setTotal(total);
        return result;
    }
    
    @Override
    @ProceedTime
    public EasyUiDataGridResult<MaterialReceiveVO> searchMaterialReceiveByReceiveId(String receiveId, int page, int rows) {
        MaterialReceiveVO materialReceive = new MaterialReceiveVO();
        Material material = new Material();

        materialReceive.setReceiveId("%" + receiveId + "%");
        materialReceive.setMaterial(material);

        return pageHandle(materialReceive, rows, page);
    }

    @Override
    @ProceedTime
    public EasyUiDataGridResult<MaterialReceiveVO> searchMaterialReceiveByMaterialId(String materialId, int page, int rows) {
        MaterialReceiveVO materialReceive = new MaterialReceiveVO();
        Material material = new Material();

        material.setMaterialId("%" + materialId + "%");
        materialReceive.setMaterial(material);

        return pageHandle(materialReceive, rows, page);
    }

    @Override
    @ProceedTime
    public MaterialReceiveVO selectMaterialReceiveByReceiveId(String receiveId) {
        return materialReceiveMapper.selectMaterialReceiveByReceiveId(receiveId);
    }

    @Override
    @ProceedTime
    public List<MaterialReceiveVO> selectAllMaterialReceive() {
        return materialReceiveMapper.selectAllMaterialReceive();
    }
}
