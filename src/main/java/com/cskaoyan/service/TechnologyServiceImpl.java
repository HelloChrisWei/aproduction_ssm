package com.cskaoyan.service;

import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.pojo.Custom;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Technology;
import com.cskaoyan.pojo.TechnologyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService{

    @Autowired
    TechnologyMapper technologyMapper;
    /*分页*/
    @Override
    public EasyUiDataGridResult<Technology> selectAllTechnologyByPage(int page, int rows) {
        EasyUiDataGridResult<Technology> result = new EasyUiDataGridResult<>();
        TechnologyExample technologyExample = new TechnologyExample();
        int total = (int) technologyMapper.countByExample(technologyExample);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Technology> orders = technologyMapper.selectAllTechnologyByPage(rows,offset);
        result.setRows(orders);
        result.getTotal(total);
        return result;
    }
    /*list*/
    @Override
    public List<Technology> technologyList() {
        List<Technology> technologies = technologyMapper.technologyList();
        return technologies;
    }

    @Override
    public boolean insertTechnology(Technology technology) {
        int insert = technologyMapper.insert(technology);
        return true;
    }
}
