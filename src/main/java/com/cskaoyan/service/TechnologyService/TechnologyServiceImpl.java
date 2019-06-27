package com.cskaoyan.service.TechnologyService;

import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Technology;
import com.cskaoyan.pojo.TechnologyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    TechnologyMapper technologyMapper;
    /*分页*/
    @Override
    public List<Technology> selectAllTechnologyByPage(int currentPage, int size) {
        List<Technology> technologies = technologyMapper.selectAllTechnologyByPage(currentPage,size);
        return technologies;
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
