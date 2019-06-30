package com.cskaoyan.service.quality.impl;

import com.cskaoyan.mapper.FinalMeasuretCheckMapper;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.FinalMeasuretCheck;
import com.cskaoyan.pojo.FinalMeasuretCheckVO;
import com.cskaoyan.pojo.ResponseStatus;

import com.cskaoyan.service.quality.MeasurementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
public class MeasurementServiceImpl implements MeasurementService {
    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;
    
    @Override
    public EasyUiDataGridResult fetchAllItems(int page, int rows) {
        EasyUiDataGridResult<FinalMeasuretCheckVO> result = new EasyUiDataGridResult<>();
        // 分页
        PageHelper.startPage(page, rows);
//        int offset = (page - 1) * rows;

        List<FinalMeasuretCheckVO> finalCountCheckVOList = finalMeasuretCheckMapper.selectAllRecords();

        PageInfo<FinalMeasuretCheckVO> info = new PageInfo<>(finalCountCheckVOList);
        // 返回查出了多少条数据
        int total = (int) info.getTotal();
        //int total = finalCountCheckVOList.size();

        result.setRows(finalCountCheckVOList);
        result.setTotal(total);

        return result;
    }

    @Override
    public EasyUiDataGridResult searchById(String fMeasureCheckId, int page, int rows) {
        EasyUiDataGridResult<FinalMeasuretCheckVO> result = new EasyUiDataGridResult<>();
        // 分页
        PageHelper.startPage(page,rows);
        int offset = (page - 1) * rows;

        // 初始化Example对象
        FinalMeasuretCheckVO example = new FinalMeasuretCheckVO();
        example.setfMeasureCheckId(fMeasureCheckId);

        List<FinalMeasuretCheckVO> finalMeasuretCheckVOList = finalMeasuretCheckMapper.selectByPrimaryKey4VO(fMeasureCheckId, rows, offset);

        // 返回查出了多少条数据
        int total = finalMeasuretCheckVOList.size();


        result.setRows(finalMeasuretCheckVOList);
        result.setTotal(1);

        return result;
    }

    @Override
    public EasyUiDataGridResult searchByOrderId(String orderId, int page, int rows) {
        EasyUiDataGridResult<FinalMeasuretCheckVO> result = new EasyUiDataGridResult<>();
        int offset = (page - 1) * rows;

        // 初始化Example对象
        FinalMeasuretCheckVO example = new FinalMeasuretCheckVO();
        example.setOrderId(orderId);

        List<FinalMeasuretCheckVO> finalMeasuretCheckVOList = finalMeasuretCheckMapper.selectByCondition4VO(example, rows, offset);
        // 返回查出了多少条数据
        int total = finalMeasuretCheckVOList.size();

        result.setRows(finalMeasuretCheckVOList);
        result.setTotal(total);

        return result;
    }

    @Override
    public ResponseStatus insert(FinalMeasuretCheck record) {
        int affectedRows = finalMeasuretCheckMapper.insert(record);
        if (affectedRows != 1) {
            return new ResponseStatus(0, "Fail", null, 0, null);

        }
        return new ResponseStatus(200, "OK", null, 0, null);
    }

    //    TODO 添加事务
    @Override
    public ResponseStatus deleteBatchByIds(String[] ids) {
        for (String id : ids) {
            int affectedRows = finalMeasuretCheckMapper.deleteByPrimaryKey(id);
            if (affectedRows != 1) {
                return new ResponseStatus(0, "Fail", null, 0, null);
            }
        }
        return new ResponseStatus(200, "OK", null, 0, null);
    }

    @Override
    public ResponseStatus updateByPrimaryKey(FinalMeasuretCheck record) {
        int affectedRows = finalMeasuretCheckMapper.updateByPrimaryKey(record);
        if (affectedRows != 1) {
            return new ResponseStatus(0, "Fail", null, 0, null);

        }
        return new ResponseStatus(200, "OK", null, 0, null);

    }

    @Override
    public ResponseStatus updateByPrimaryKeySelective(FinalMeasuretCheck record) {
        int affectedRows = finalMeasuretCheckMapper.updateByPrimaryKeySelective(record);
        if (affectedRows != 1) {
            return new ResponseStatus(0, "Fail", null, 0, null);

        }
        return new ResponseStatus(200, "OK", null, 0, null);
    }
}
