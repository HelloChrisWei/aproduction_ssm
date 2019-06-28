package com.cskaoyan.service.measurement.impl;

import com.cskaoyan.mapper.FinalMeasuretCheckMapper;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.FinalMeasuretCheckVO;
import com.cskaoyan.pojo.UnqualifyApplyVO;
import com.cskaoyan.service.measurement.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @version 1.0 2019/6/28
 * @author Wei
 */
@Service
public class MeasurementServiceImpl implements MeasurementService {
    @Autowired
    private FinalMeasuretCheckMapper finalMeasuretCheckMapper;

    /**
     * 根据页码和条目数返回记录List
     * @param page 当前是第几页
     * @param rows 每页包含的记录数
     * @return
     */
    @Override
    public EasyUiDataGridResult getMeasurementList(int page, int rows) {
        EasyUiDataGridResult<FinalMeasuretCheckVO> result = new EasyUiDataGridResult<>();
        int offset = (page - 1) * rows;

        List<FinalMeasuretCheckVO> finalMeasuretCheckVOList = finalMeasuretCheckMapper.selectAllRecords(rows, offset);

        // 返回查出了多少条数据
        int total = finalMeasuretCheckVOList.size();

        result.setRows(finalMeasuretCheckVOList);
        result.setTotal(total);

        return result;
    }
}
