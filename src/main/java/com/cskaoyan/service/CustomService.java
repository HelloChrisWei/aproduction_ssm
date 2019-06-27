package com.cskaoyan.service;

import com.cskaoyan.exception.CustomException;
import com.cskaoyan.pojo.Custom;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;

import java.util.List;

public interface CustomService {

    EasyUiDataGridResult<Custom> selectAllCustomByPage(int page, int rows);

    ResponseStatus insert(Custom custom);

    ResponseStatus updateByPrimaryKeySelective(Custom custom);

    ResponseStatus deleteBatch(String[] ids) throws CustomException;

    EasyUiDataGridResult<Custom> searchCustomByCustomId(String customId, int page, int rows);

    EasyUiDataGridResult<Custom> searchCustomByCustomName(String customName, int page, int rows);

    Custom selectCustomByCustomId(String customId);

    List<Custom> selectAllCustom();

}
