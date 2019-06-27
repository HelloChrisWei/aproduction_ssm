package com.cskaoyan.service.impl;

import com.cskaoyan.exception.CustomException;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.pojo.Custom;
import com.cskaoyan.pojo.CustomExample;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {

    @Autowired
    private CustomMapper customMapper;

    @Override
    public EasyUiDataGridResult<Custom> selectAllCustomByPage(int page, int rows) {
        EasyUiDataGridResult<Custom> result = new EasyUiDataGridResult<>();
        CustomExample example = new CustomExample();

        int total = (int) customMapper.countByExample(example);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<Custom> orders = customMapper.selectAllCustomByPage(rows, offset);
        result.setRows(orders);
        result.setTotal(total);
        return result;
    }

    @Override
    public ResponseStatus insert(Custom custom) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isAdd = customMapper.insertSelective(custom);
            if (isAdd == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("该客户编号已存在，请更改客户编号，重新添加！");
        }
        return status;
    }

    @Override
    public ResponseStatus updateByPrimaryKeySelective(Custom custom) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isUpdate = customMapper.updateByPrimaryKeySelective(custom);
            if (isUpdate == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("客户修改失败！请重试！");
        }
        return status;
    }

    @Override
    public ResponseStatus deleteBatch(String[] ids) throws CustomException {
        ResponseStatus status = new ResponseStatus();
        try {
            for (String id : ids) {
                customMapper.deleteByPrimaryKey(id);
            }
            status.setStatus(200);
            status.setMsg("OK");
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("客户批量删除失败，请重试！");
            throw new CustomException("客户批量删除失败，请重试！");
        }
        return status;
    }

    private EasyUiDataGridResult<Custom> pageHandle(Custom custom, int rows, int page) {
        EasyUiDataGridResult<Custom> result = new EasyUiDataGridResult<>();

        int total = customMapper.selectCustomCountByCondition(custom);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<Custom> customs = customMapper.selectCustomByConditionByPage(custom, rows, offset);
        result.setRows(customs);
        result.setTotal(total);
        return result;
    }

    @Override
    public EasyUiDataGridResult<Custom> searchCustomByCustomId(String customId, int page, int rows) {
        Custom custom = new Custom();
        custom.setCustomId("%" + customId + "%");
        return pageHandle(custom, rows, page);
    }

    @Override
    public EasyUiDataGridResult<Custom> searchCustomByCustomName(String customName, int page, int rows) {
        Custom custom = new Custom();
        custom.setCustomId("%" + customName + "%");
        return pageHandle(custom, rows, page);
    }

    @Override
    public Custom selectCustomByCustomId(String customId) {
        return customMapper.selectByPrimaryKey(customId);
    }

    @Override
    public List<Custom> selectAllCustom() {
        return customMapper.selectAllCustom();
    }
}
