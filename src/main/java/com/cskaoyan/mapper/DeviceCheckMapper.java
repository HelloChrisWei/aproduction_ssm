package com.cskaoyan.mapper;

import com.cskaoyan.pojo.DeviceCheck;
import com.cskaoyan.pojo.DeviceCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceCheckMapper {
    List findAllDeviceCheck();

    long countByExample(DeviceCheckExample example);

    int deleteByExample(DeviceCheckExample example);

    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    List<DeviceCheck> selectByExample(DeviceCheckExample example);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByExampleSelective(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByExample(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);
}