package com.cskaoyan.service.quality.impl;

import com.cskaoyan.mapper.ProcessCountCheckMapper;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.quality.ProcessCountCheckService;
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
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {
    
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;

    @Override
    public EasyUiDataGridResult fetchAllItems(int page, int rows) {
        EasyUiDataGridResult<ProcessCountCheckVO> result = new EasyUiDataGridResult<>();
        int offset = (page - 1) * rows;

        List<ProcessCountCheckVO> processCountCheckVOList = processCountCheckMapper.selectAllRecords(rows, offset);

        // 返回查出了多少条数据
        int total = processCountCheckVOList.size();

        result.setRows(processCountCheckVOList);
        result.setTotal(total);

        return result;
    }

    @Override
    public EasyUiDataGridResult searchById(String pCountCheckId, int page, int rows) {
        EasyUiDataGridResult<ProcessCountCheckVO> result = new EasyUiDataGridResult<>();
        int offset = (page - 1) * rows;

        // 初始化Example对象
        ProcessCountCheckVO example = new ProcessCountCheckVO();
        example.setpCountCheckId(pCountCheckId);

        List<ProcessCountCheckVO> processCountCheckVOList = processCountCheckMapper.selectByPrimaryKey4VO(example, rows, offset);

        // 返回查出了多少条数据
        int total = processCountCheckVOList.size();

        result.setRows(processCountCheckVOList);
        result.setTotal(total);

        return result;
    }


    //    TODO 添加事务
    @Override
    public ResponseStatus deleteBatchByIds(String[] ids) {
        for (String id : ids) {
            int affectedRows = processCountCheckMapper.deleteByPrimaryKey(id);
            if (affectedRows != 1) {
                return new ResponseStatus(0, "Fail", null, 0, null);
            }
        }
        return new ResponseStatus(200, "OK", null, 0, null);
    }

    @Override
    public ResponseStatus updateByPrimaryKey(ProcessCountCheck record) {
        int affectedRows = processCountCheckMapper.updateByPrimaryKey(record);
        if (affectedRows != 1) {
            return new ResponseStatus(0, "Fail", null, 0, null);

        }
        return new ResponseStatus(200, "OK", null, 0, null);

    }

    @Override
    public ResponseStatus updateByPrimaryKeySelective(ProcessCountCheck record) {
        int affectedRows = processCountCheckMapper.updateByPrimaryKeySelective(record);
        if (affectedRows != 1) {
            return new ResponseStatus(0, "Fail", null, 0, null);

        }
        return new ResponseStatus(200, "OK", null, 0, null);
    }
}
