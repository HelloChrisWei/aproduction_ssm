package com.cskaoyan.service;

import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.pojo.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService{

    @Autowired
    TechnologyMapper technologyMapper;

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
