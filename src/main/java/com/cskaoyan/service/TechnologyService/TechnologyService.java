package com.cskaoyan.service.TechnologyService;


import com.cskaoyan.pojo.Custom;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Technology;


import java.util.List;

public interface TechnologyService {
    boolean insertTechnology(Technology technology);
    List<Technology> technologyList();
    List<Technology> selectAllTechnologyByPage(int currentPage, int size);

}
