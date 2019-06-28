package com.cskaoyan.service.TechnologyService;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.TechnologyRequirement;
import org.springframework.stereotype.Service;

public interface TechnologyRequirementService {
    EasyUiDataGridResult<TechnologyRequirement> selectAllTechnologyRequirement(int page,int rows);
}
