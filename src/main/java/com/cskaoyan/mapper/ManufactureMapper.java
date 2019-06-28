package com.cskaoyan.mapper;

import com.cskaoyan.pojo.Manufacture;
import com.cskaoyan.pojo.ManufactureExample;
import java.util.List;

import com.cskaoyan.pojo.ManufactureVO;
import org.apache.ibatis.annotations.Param;

public interface ManufactureMapper {
    long countByExample(ManufactureExample example);

    int deleteByExample(ManufactureExample example);

    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    List<Manufacture> selectByExample(ManufactureExample example);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByExampleSelective(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByExample(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    // 自主添加的接口
    int selectManufactureCountByCondition(@Param("manufacture") ManufactureVO manufacture);

    ManufactureVO selectManufactureByManufactureSn(@Param("manufactureSn") String manufactureSn);

    List<ManufactureVO> selectAllManufacture();

    List<ManufactureVO> selectAllManufactureByPage(@Param("rows") int rows, @Param("offset") int offset);

    List<ManufactureVO> selectManufactureByConditionByPage(@Param("manufacture") ManufactureVO manufacture, @Param("rows") int rows, @Param("offset") int offset);

}