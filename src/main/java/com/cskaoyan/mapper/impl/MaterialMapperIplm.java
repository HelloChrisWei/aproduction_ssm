package com.cskaoyan.mapper.impl;

import com.cskaoyan.mapper.MaterialMapper;
import com.cskaoyan.pojo.Material;
import com.cskaoyan.pojo.MaterialExample;

import java.util.List;

public class MaterialMapperIplm implements MaterialMapper {
    @Override
    public long countByExample(MaterialExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(MaterialExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String materialId) {
        return 0;
    }

    @Override
    public int insert(Material record) {
        return 0;
    }

    @Override
    public int insertSelective(Material record) {
        return 0;
    }

    @Override
    public List<Material> selectByExample(MaterialExample example) {
        return null;
    }

    @Override
    public Material selectByPrimaryKey(String materialId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Material record, MaterialExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Material record, MaterialExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Material record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Material record) {
        return 0;
    }
}
