package com.cskaoyan.service.TechnologyService;

import com.cskaoyan.exception.CustomException;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.pojo.Technology;
import com.cskaoyan.pojo.TechnologyExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    TechnologyMapper technologyMapper;
    /*分页*/
    @Override
    //从网页获取的json数据page和rows传入
    public EasyUiDataGridResult<Technology> selectAllTechnologyByPage(int page,int rows) {
        PageHelper.startPage(page,rows);
        //创建EasyUiDataGridResult类，目的:封装list数据
        EasyUiDataGridResult<Technology> easyUiDataGridResult = new EasyUiDataGridResult<>();
        //目的:获取总条目数
        TechnologyExample technologyExample = new TechnologyExample();
        //封装list
        easyUiDataGridResult.setRows( technologyMapper.selectAllTechnologyByPage());
        //获取总数
        easyUiDataGridResult.setTotal((int) technologyMapper.countByExample(technologyExample));
        return easyUiDataGridResult;
    }
    /*list*/
    /*@Override
    public List<Technology> technologyList() {
        List<Technology> technologies = technologyMapper.technologyList();
        return technologies;
    }*/

    @Override
    public ResponseStatus insertTechnology(Technology record) {
        ResponseStatus responseStatus = new ResponseStatus();

        try {
            int insert = technologyMapper.insert(record);
            if (insert != 0){
                responseStatus.setStatus(200);
                responseStatus.setMsg("Ok");
            }
        }catch (Exception e){
            e.printStackTrace();
            responseStatus.setStatus(500);
            responseStatus.setMsg("error");
        }
        return responseStatus;

    }

    @Override
    public ResponseStatus updateTechnology(Technology record) {
        ResponseStatus responseStatus = new ResponseStatus();
        try {
            int update = technologyMapper.updateByPrimaryKeySelective(record);
            if (update != 0){
                responseStatus.setStatus(200);
                responseStatus.setMsg("ok");
            }
        }catch (Exception e){
            e.printStackTrace();
            responseStatus.setStatus(500);
            responseStatus.setMsg("error");
        }
        return responseStatus;
    }

    @Override
    public ResponseStatus deleteBatchTechnology(String[] ids) {
        ResponseStatus responseStatus = new ResponseStatus();

        try {
            for (String i:ids) {
                int delete = technologyMapper.deleteByPrimaryKey(i);
                if (delete != 0){
                    responseStatus.setStatus(200);
                    responseStatus.setMsg("ok");
                }
            }
            //int delete = technologyMapper.deleteByPrimaryKey("id");
        }catch (Exception e){
            e.printStackTrace();
            responseStatus.setStatus(500);
            responseStatus.setMsg("批量删除失败，请重试");
        }
        return responseStatus;
    }

    @Override
    public Technology searchTechnologyData(String technologyId) {
        Technology technology;
        technology = technologyMapper.selectByPrimaryKey(technologyId);
        return technology;
    }

    @Override
    public List<Technology> findTechnologyData() {
        return technologyMapper.selectAllTechnology();
    }

    @Override
    public EasyUiDataGridResult<Technology> search_technology_by_technologyId(String tId, int page, int rows) {
        String id = "%" + tId + "%";
        EasyUiDataGridResult<Technology> result = new EasyUiDataGridResult<>();

        PageHelper.startPage(page, rows);
        List<Technology> technologies = technologyMapper.selectTechnologyById(id);

        PageInfo<Technology> info = new PageInfo<>(technologies);
        int total = (int)info.getTotal();
        //int total = (int) requirementMapper.countByExampleByCondition(record);
        result.setRows(technologies);
        result.setTotal(total);
        return result;
    }

    @Override
    public EasyUiDataGridResult<Technology> search_technologyPlan_by_technologyName(String tName, int page, int rows) {
        String name = "%" + tName + "%";
        EasyUiDataGridResult<Technology> result = new EasyUiDataGridResult<>();

        PageHelper.startPage(page, rows);
        List<Technology> technologies = technologyMapper.selectTechnologyByName(name);

        PageInfo<Technology> info = new PageInfo<>(technologies);
        int total = (int)info.getTotal();
        //int total = (int) requirementMapper.countByExampleByCondition(record);
        result.setRows(technologies);
        result.setTotal(total);
        return result;
    }
}
