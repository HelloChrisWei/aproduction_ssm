package com.cskaoyan.mapper;

import com.cskaoyan.pojo.DeviceMaintain;
import com.cskaoyan.pojo.DeviceMaintainExample;
import java.util.List;

import com.cskaoyan.pojo.DeviceMaintainVO;
import org.apache.ibatis.annotations.Param;

public interface DeviceMaintainMapper {
    List<DeviceMaintain> findAllDeviceMaintain();

    List<DeviceMaintainVO> findDeviceMaintain();

    List<DeviceMaintainVO> searchByMaintainId(String MaintainId);

    List<DeviceMaintainVO> searchByDeviceFaultId(String DeviceFaultId);

    long countByExample(DeviceMaintainExample example);

    int deleteByExample(DeviceMaintainExample example);

    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    List<DeviceMaintain> selectByExample(DeviceMaintainExample example);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByExampleSelective(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByExample(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);
}