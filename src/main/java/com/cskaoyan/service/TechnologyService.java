package com.cskaoyan.service;


import com.cskaoyan.pojo.Technology;


import java.util.List;

public interface TechnologyService {
    boolean insertTechnology(Technology technology);
    List<Technology> technologyList();


}
