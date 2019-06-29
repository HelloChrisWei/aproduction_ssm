package com.cskaoyan.service.quality.impl;

import com.cskaoyan.mapper.FinalCountCheckMapper;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.FinalCountCheck;
import com.cskaoyan.pojo.FinalCountCheckVO;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.quality.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @version 1.0 2019/6/29
 * @author Wei
 */
@Service
public class FinalCountCheckServiceImpl implements FinalCountCheckService {

    @Autowired
    private FinalCountCheckMapper finalCountCheckMapper;

    @Override
    public EasyUiDataGridResult fetchAllItems(int page, int rows) {
        EasyUiDataGridResult<FinalCountCheckVO> result = new EasyUiDataGridResult<>();
        int offset = (page - 1) * rows;

        List<FinalCountCheckVO> finalCountCheckVOList = finalCountCheckMapper.selectAllRecords(rows, offset);

        // 返回查出了多少条数据
        int total = finalCountCheckVOList.size();

        result.setRows(finalCountCheckVOList);
        result.setTotal(total);

        return result;
    }

    @Override
    public EasyUiDataGridResult searchById(String fCountCheckId, int page, int rows) {
        EasyUiDataGridResult<FinalCountCheckVO> result = new EasyUiDataGridResult<>();
        List<FinalCountCheckVO> finalCountCheckVOList = new ArrayList<>();

        int offset = (page - 1) * rows;

        // 初始化Example对象
        FinalCountCheckVO example = new FinalCountCheckVO();
        example.setfCountCheckId(fCountCheckId);

        FinalCountCheckVO finalCountCheckVO = finalCountCheckMapper.selectByPrimaryKey4VO(fCountCheckId, rows, offset);

        if (finalCountCheckVO != null) {
            finalCountCheckVOList.add(finalCountCheckVO);
        }

        result.setRows(finalCountCheckVOList);
        result.setTotal(1);

        return result;
    }

    @Override
    public EasyUiDataGridResult searchByOrderId(String orderId, int page, int rows) {
        EasyUiDataGridResult<FinalCountCheckVO> result = new EasyUiDataGridResult<>();
        int offset = (page - 1) * rows;

        // 初始化Example对象
        FinalCountCheckVO example = new FinalCountCheckVO();
        example.setOrderId(orderId);

        List<FinalCountCheckVO> finalCountCheckVOList = finalCountCheckMapper.selectByCondition4VO(example, rows, offset);
        // 返回查出了多少条数据
        int total = finalCountCheckVOList.size();

        result.setRows(finalCountCheckVOList);
        result.setTotal(total);

        return result;
    }

//    TODO 添加事务
    @Override
    public ResponseStatus deleteBatchByIds(String[] ids) {
        for (String id : ids) {
            int affectedRows = finalCountCheckMapper.deleteByPrimaryKey(id);
            if (affectedRows != 1) {
                return new ResponseStatus(0, "Fail", null, 0, null);
            }
        }
        return new ResponseStatus(200, "OK", null, 0, null);
    }

    @Override
    public ResponseStatus updateByPrimaryKey(FinalCountCheck record) {
        int affectedRows = finalCountCheckMapper.updateByPrimaryKey(record);
        if (affectedRows != 1) {
            return new ResponseStatus(0, "Fail", null, 0, null);

        }
        return new ResponseStatus(200, "OK", null, 0, null);

    }

    @Override
    public ResponseStatus updateByPrimaryKeySelective(FinalCountCheck record) {
        int affectedRows = finalCountCheckMapper.updateByPrimaryKeySelective(record);
        if (affectedRows != 1) {
            return new ResponseStatus(0, "Fail", null, 0, null);

        }
        return new ResponseStatus(200, "OK", null, 0, null);
    }


}
