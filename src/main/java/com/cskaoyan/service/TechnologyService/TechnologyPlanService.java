package com.cskaoyan.service.TechnologyService;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.pojo.TechnologyPlan;

import java.util.List;

public interface TechnologyPlanService {
    EasyUiDataGridResult<TechnologyPlan> selectAllTechnologyPlanByPage(int page,int rows);

    ResponseStatus insertTechnologyPlan(TechnologyPlan record);

    ResponseStatus updateTechnologyPlan(TechnologyPlan record);

    ResponseStatus deleteBatchTechnologyPlan(String[] ids);

    EasyUiDataGridResult<TechnologyPlan> search_technologyPlan_by_technologyPlanId(String pId, int page, int rows);

    EasyUiDataGridResult<TechnologyPlan> search_technologyPlan_by_technologyName(String tName, int page, int rows);

    List<TechnologyPlan> findTechnologyPlanData();

    TechnologyPlan searchTechnologyPlanData(String technologyPlanId);
}
