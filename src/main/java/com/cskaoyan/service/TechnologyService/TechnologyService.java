package com.cskaoyan.service.TechnologyService;


import com.cskaoyan.pojo.Custom;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.pojo.Technology;


import java.util.List;

public interface TechnologyService {
    //显示所有数据
    EasyUiDataGridResult<Technology> selectAllTechnologyByPage(int page,int rows);
    //增加操作
    ResponseStatus insertTechnology(Technology record);
    //修改操作
    ResponseStatus updateTechnology(Technology record);
    //删除操作
    ResponseStatus deleteBatchTechnology(String[] ids);
    //回显
    Technology searchTechnologyData(String technologyId);
    //数据列表
    List<Technology> findTechnologyData();

    EasyUiDataGridResult<Technology> search_technology_by_technologyId(String tId, int page, int rows);

    EasyUiDataGridResult<Technology> search_technologyPlan_by_technologyName(String tName, int page, int rows);
}
