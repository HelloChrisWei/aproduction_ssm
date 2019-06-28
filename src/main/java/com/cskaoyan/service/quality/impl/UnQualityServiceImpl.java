package com.cskaoyan.service.quality.impl;

import com.cskaoyan.mapper.UnqualifyApplyMapper;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.quality.UnQualityService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @version 1.0 2019/6/26
 * @author Wei
 */
@Service
public class UnQualityServiceImpl implements UnQualityService {
    @Autowired
    private UnqualifyApplyMapper unqualifyApplyMapper;

    /**
     * 根据页码和条目数返回记录List
     * @param page 当前是第几页
     * @param rows 每页包含的记录数
     * @return
     */
    @Override
    public List<UnqualifyApplyVO> getUnqualityList(int page, int rows) {
        int total = (int) unqualifyApplyMapper.countByExample(new UnqualifyApplyExample());

        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<UnqualifyApplyVO> unqualifyApplyVOList = unqualifyApplyMapper.selectAllRecords(rows, offset);

        return unqualifyApplyVOList;
    }

    /**
     * 返回总条目数
     * @return
     */
    @Override
    public int getTotalRecordNum() {
        return (int) unqualifyApplyMapper.countByExample(new UnqualifyApplyExample());
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public boolean deleteBatch(String[] ids) {
        for (String id : ids) {
            int affectedRows = unqualifyApplyMapper.deleteByPrimaryKey(id);
            if (affectedRows != 1) {
                return false;
            }
        }
        return true;
    }
}
