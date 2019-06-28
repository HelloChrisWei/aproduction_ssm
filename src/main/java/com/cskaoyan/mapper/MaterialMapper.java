package com.cskaoyan.mapper;

import com.cskaoyan.pojo.Material;
import com.cskaoyan.pojo.MaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialMapper {
    long countByExample(MaterialExample example);

    int deleteByExample(MaterialExample example);

    int deleteByPrimaryKey(String materialId);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByExample(MaterialExample example);

    Material selectByPrimaryKey(String materialId);

    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByExample(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

    //自增接口
    List<Material> selectAllMaterialByPage(@Param("rows") int rows, @Param("offset") int offset);

    int selectMaterialCountByCondition(@Param("material") Material material);

    List<Material> selectMaterialByConditionByPage(@Param("material") Material material, @Param("rows") int rows, @Param("offset") int offset);

    List<Material> selectAllMaterial();
    
}