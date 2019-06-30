package com.cskaoyan.service.TechnologyService;

import com.cskaoyan.pojo.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TechnologyRequirementService {
    EasyUiDataGridResult<TechnologyRequirement> selectAllTechnologyRequirement(int page,int rows);

    ResponseStatus insertTechnologyRequirement(TechnologyRequirement record);

    ResponseStatus updateTechnologyRequirement(TechnologyRequirement record);

    ResponseStatus deleteBatchTechnologyRequirement(String[] ids);


    EasyUiDataGridResult<TechnologyRequirement> search_technologyRequirement_by_technologyRequirementId(String tRId, int page, int rows);

    EasyUiDataGridResult<TechnologyRequirement> search_technologyRequirement_by_technologyName(String tName, int page, int rows);
}
