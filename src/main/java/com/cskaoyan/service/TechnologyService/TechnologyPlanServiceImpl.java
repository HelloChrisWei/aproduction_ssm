package com.cskaoyan.service.TechnologyService;

import com.cskaoyan.mapper.TechnologyPlanMapper;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.pojo.TechnologyPlan;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService{
    @Autowired
    TechnologyPlanMapper technologyPlanMapper;

    @Override
    public EasyUiDataGridResult<TechnologyPlan> selectAllTechnologyPlanByPage(int page, int rows) {
        EasyUiDataGridResult<TechnologyPlan> result = new EasyUiDataGridResult<>();
        PageHelper.startPage(page,rows);
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.selectAllTechnologyPlanByPage();
        PageInfo<TechnologyPlan> info = new PageInfo<>(technologyPlans);
        int total = (int) info.getTotal();
        result.setTotal(total);
        result.setRows(technologyPlans);
        return result;
    }

    @Override
    public ResponseStatus insertTechnologyPlan(TechnologyPlan record) {
        ResponseStatus status = new ResponseStatus();
        try {
            int insert = technologyPlanMapper.insert(record);
            if (insert != 0){
                status.setMsg("ok");
                status.setStatus(200);
                return status;
            }
        }catch (Exception e){
            e.printStackTrace();
            status.setStatus(500);
            status.setMsg("error");
        }
        return status;
    }

    @Override
    public ResponseStatus updateTechnologyPlan(TechnologyPlan record) {
        ResponseStatus status = new ResponseStatus();
        try {
            int insert = technologyPlanMapper.updateByPrimaryKeySelective(record);
            if (insert != 0){
                status.setMsg("ok");
                status.setStatus(200);
                return status;
            }
        }catch (Exception e){
            e.printStackTrace();
            status.setStatus(500);
            status.setMsg("error");
        }
        return status;
    }

    @Override
    public ResponseStatus deleteBatchTechnologyPlan(String[] ids) {
        ResponseStatus status = new ResponseStatus();
        try {
            for (String id:ids) {
                int delete = technologyPlanMapper.deleteByPrimaryKey(id);
                if (delete != 0) {
                    status.setStatus(200);
                    status.setMsg("ok");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(500);
            status.setMsg("error");
        }
        return status;
    }

    @Override
    public EasyUiDataGridResult<TechnologyPlan> search_technologyPlan_by_technologyPlanId(String pId, int page, int rows) {
        EasyUiDataGridResult<TechnologyPlan> result = new EasyUiDataGridResult<>();
        PageHelper.startPage(page,rows);
        String id = "%" +pId + "%";
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.selectTechnologyPlanByPId(id);
        PageInfo<TechnologyPlan> info = new PageInfo<>(technologyPlans);
        int total = (int) info.getTotal();
        result.setTotal(total);
        result.setRows(technologyPlans);
        return result;
    }

    @Override
    public EasyUiDataGridResult<TechnologyPlan> search_technologyPlan_by_technologyName(String tName, int page, int rows) {
        EasyUiDataGridResult<TechnologyPlan> result = new EasyUiDataGridResult<>();
        PageHelper.startPage(page,rows);
        String name = "%" +tName + "%";
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.selectTechnologyPlanByTName(name);
        PageInfo<TechnologyPlan> info = new PageInfo<>(technologyPlans);
        int total = (int) info.getTotal();
        result.setTotal(total);
        result.setRows(technologyPlans);
        return result;
    }

    @Override
    public List<TechnologyPlan> findTechnologyPlanData() {
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.findTechnologyPlanData();
        return technologyPlans;
    }

    @Override
    public TechnologyPlan searchTechnologyPlanData(String technologyPlanId) {
        return technologyPlanMapper.selectByPrimaryKey(technologyPlanId);
    }
}
