package com.cskaoyan.service.TechnologyService;

import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.mapper.TechnologyRequirementMapper;
import com.cskaoyan.pojo.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService{

    @Autowired
    TechnologyRequirementMapper requirementMapper;


    @Override
    public EasyUiDataGridResult<TechnologyRequirement> selectAllTechnologyRequirement(int page, int rows) {
        EasyUiDataGridResult<TechnologyRequirement> result = new EasyUiDataGridResult<>();
        //pageHelper接收的前端数据
        PageHelper.startPage(page,rows);
        //查询所有requirement数据并封装为一个list
        List<TechnologyRequirement> requirements = requirementMapper.selectAllTechnologyRequirementByPage();

        TechnologyRequirementExample requirementExample = new TechnologyRequirementExample();
        //查询total(总条目数)
        int total = (int)requirementMapper.countByExample(requirementExample);
        //将总数和数据封装为一个bean返回给前端
        result.setTotal(total);

        result.setRows(requirements);

        return result;
    }

    @Override
    public ResponseStatus insertTechnologyRequirement(TechnologyRequirement record) {
        ResponseStatus status = new ResponseStatus();
        try{
            int insert = requirementMapper.insert(record);
            if (insert != 0){
                status.setStatus(200);
                status.setMsg("ok");
            }
        }catch (Exception e){
            e.printStackTrace();
            status.setStatus(500);
            status.setMsg("error");
        }
        return status;
    }

    @Override
    public ResponseStatus updateTechnologyRequirement(TechnologyRequirement record) {
        ResponseStatus status = new ResponseStatus();
        try {
            int update = requirementMapper.updateByPrimaryKeySelective(record);
            if (update != 0){
                status.setStatus(200);
                status.setMsg("ok");
            }
        }catch (Exception e){
            e.printStackTrace();
            status.setStatus(500);
            status.setMsg("error");
        }

        return status;
    }

    @Override
    public ResponseStatus deleteBatchTechnologyRequirement(String[] ids) {
        ResponseStatus status = new ResponseStatus();
        try{
            for (String i:ids) {
                int delete = requirementMapper.deleteByPrimaryKey(i);
                if (delete != 0){
                    status.setStatus(200);
                    status.setMsg("ok");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            status.setStatus(500);
            status.setMsg("error");
        }
        return status;
    }


}
