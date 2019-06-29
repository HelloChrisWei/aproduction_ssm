package com.cskaoyan.mapper;

import com.cskaoyan.pojo.Device;
import com.cskaoyan.pojo.DeviceExample;
import java.util.List;

import com.cskaoyan.pojo.DeviceVO;
import org.apache.ibatis.annotations.Param;

public interface DeviceMapper {
    //用来返回所有的Device列表
    List<Device> findAllDeviceList();
    //用来显示页面类处多表查询的信息
    List<DeviceVO> findDeviceList();

    int addList(Device device);
    long countByExample(DeviceExample example);

    int deleteByExample(DeviceExample example);

    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExample(DeviceExample example);

    Device selectByPrimaryKey(String deviceId);

    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}