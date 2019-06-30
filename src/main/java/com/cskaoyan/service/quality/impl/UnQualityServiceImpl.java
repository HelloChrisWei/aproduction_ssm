package com.cskaoyan.service.quality.impl;

import com.cskaoyan.mapper.UnqualifyApplyMapper;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.quality.UnQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public EasyUiDataGridResult getUnqualityList(int page, int rows) {
        EasyUiDataGridResult<UnqualifyApplyVO> result = new EasyUiDataGridResult<>();
        int offset = (page - 1) * rows;

        List<UnqualifyApplyVO> unqualifyApplyVOList = unqualifyApplyMapper.selectAllRecords(rows, offset);

        // 返回查出了多少条数据
        int total = unqualifyApplyVOList.size();

        result.setRows(unqualifyApplyVOList);
        result.setTotal(total);

        return result;
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


    @Override
    public ResponseStatus updateByPrimaryKeySelective(UnqualifyApply record) {
        if (unqualifyApplyMapper.updateByPrimaryKeySelective(record) != 1) {
            return new ResponseStatus(0, "更新备注失败", null, 0, null);
        }
        return new ResponseStatus(200, null, null, 0, null);
    }


    @Override
    public ResponseStatus updateByPrimaryKey(UnqualifyApply record) {
        if (unqualifyApplyMapper.updateByPrimaryKey(record) != 1) {
            return new ResponseStatus(0, "更新失败", null, 0, null);
        }
        return new ResponseStatus(200, null, null, 0, null);
    }

    @Override
    public EasyUiDataGridResult searchById(String unqualifyApplyId, int page, int rows) {
        EasyUiDataGridResult<UnqualifyApplyVO> result = new EasyUiDataGridResult<>();
        List<UnqualifyApplyVO> unqualifyApplyVOList = new ArrayList<>();

        UnqualifyApplyVO unqualifyApplyVO = unqualifyApplyMapper.selectByPrimaryKeyVO(unqualifyApplyId);
        // 防止出现rows=[null]从而造成在搜索栏中输入了不存在的ID，页面还显示所有数据
        if (unqualifyApplyVO != null) {
            unqualifyApplyVOList.add(unqualifyApplyVO);
        }

        result.setRows(unqualifyApplyVOList);
        result.setTotal(1);

        return result;
    }

    @Override
    public EasyUiDataGridResult selectByExample(UnqualifyApplyVO unqualifyApplyVOExample, int page, int rows) {
        EasyUiDataGridResult<UnqualifyApplyVO> result = new EasyUiDataGridResult<>();
        int offset = (page - 1) * rows;

        List<UnqualifyApplyVO> unqualifyApplyVOList = unqualifyApplyMapper.selectByExampleVO(unqualifyApplyVOExample, rows, offset);

        // 返回查出了多少条数据
        int total = unqualifyApplyVOList.size();

        result.setRows(unqualifyApplyVOList);
        result.setTotal(total);

        return result;
    }

    @Override
    public ResponseStatus insert(UnqualifyApply record) {
        int affectedRows = unqualifyApplyMapper.insert(record);
        if (affectedRows != 1) {
            return new ResponseStatus(0, "Fail", null, 0, null);

        }
        return new ResponseStatus(200, "OK", null, 0, null);
    }
}
