package com.cskaoyan.service.quality.impl;

import com.cskaoyan.mapper.ProcessMeasureCheckMapper;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.quality.ProcessMeasureCheckService;
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
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService {
    @Autowired
    private ProcessMeasureCheckMapper processMeasureCheckMapper;


    @Override
    public EasyUiDataGridResult fetchAllItems(int page, int rows) {
        EasyUiDataGridResult<ProcessMeasureCheckVO> result = new EasyUiDataGridResult<>();
        int offset = (page - 1) * rows;

        List<ProcessMeasureCheckVO> processMeasureCheckVOList = processMeasureCheckMapper.selectAllRecords(rows, offset);

        // 返回查出了多少条数据
        int total = processMeasureCheckVOList.size();

        result.setRows(processMeasureCheckVOList);
        result.setTotal(total);

        return result;
    }
    
    @Override
    public EasyUiDataGridResult searchById(String pMeasureCheckId, int page, int rows) {
        EasyUiDataGridResult<ProcessMeasureCheckVO> result = new EasyUiDataGridResult<>();
        int offset = (page - 1) * rows;

        // 初始化Example对象
        ProcessMeasureCheckVO example = new ProcessMeasureCheckVO();
        example.setpMeasureCheckId(pMeasureCheckId);

        List<ProcessMeasureCheckVO> processMeasureCheckVOList = processMeasureCheckMapper.selectByPrimaryKey4VO(example, rows, offset);

        // 返回查出了多少条数据
        int total = processMeasureCheckVOList.size();

        result.setRows(processMeasureCheckVOList);
        result.setTotal(total);

        return result;
    }

    
    //    TODO 添加事务
    @Override
    public ResponseStatus deleteBatchByIds(String[] ids) {
        for (String id : ids) {
            int affectedRows = processMeasureCheckMapper.deleteByPrimaryKey(id);
            if (affectedRows != 1) {
                return new ResponseStatus(0, "Fail", null, 0, null);
            }
        }
        return new ResponseStatus(200, "OK", null, 0, null);
    }

    @Override
    public ResponseStatus updateByPrimaryKey(ProcessMeasureCheck record) {
        int affectedRows = processMeasureCheckMapper.updateByPrimaryKey(record);
        if (affectedRows != 1) {
            return new ResponseStatus(0, "Fail", null, 0, null);

        }
        return new ResponseStatus(200, "OK", null, 0, null);

    }

    @Override
    public ResponseStatus updateByPrimaryKeySelective(ProcessMeasureCheck record) {
        int affectedRows = processMeasureCheckMapper.updateByPrimaryKeySelective(record);
        if (affectedRows != 1) {
            return new ResponseStatus(0, "Fail", null, 0, null);

        }
        return new ResponseStatus(200, "OK", null, 0, null);
    }
}
