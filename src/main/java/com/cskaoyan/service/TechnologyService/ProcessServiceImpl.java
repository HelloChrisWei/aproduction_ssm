package com.cskaoyan.service.TechnologyService;

import com.cskaoyan.mapper.ProcessMapper;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Process;
import com.cskaoyan.pojo.ResponseStatus;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService{
    @Autowired
    ProcessMapper processMapper;

    @Override
    public EasyUiDataGridResult<Process> selectAllProcessByPage(int page, int rows) {
        EasyUiDataGridResult<Process> result = new EasyUiDataGridResult<>();
        //pageHelper接收的前端数据
        PageHelper.startPage(page, rows);
        //查询所有requirement数据并封装为一个list
        List<Process> requirements = processMapper.selectAllProcessByPage();

        PageInfo<Process> info = new PageInfo<>(requirements);
        //查询total(总条目数)
        int total = (int) info.getTotal();
        //将总数和数据封装为一个bean返回给前端
        result.setTotal(total);

        result.setRows(requirements);

        return result;
    }

    @Override
    public ResponseStatus insertProcess(Process record) {
        ResponseStatus status = new ResponseStatus();
        try {
            int insert = processMapper.insert(record);
            if (insert != 0) {
                status.setStatus(200);
                status.setMsg("ok");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(500);
            status.setMsg("error");
        }
        return status;
    }

    @Override
    public ResponseStatus updateProcess(Process record) {
        ResponseStatus status = new ResponseStatus();
        try {
            int insert = processMapper.updateByPrimaryKey(record);
            if (insert != 0) {
                status.setStatus(200);
                status.setMsg("ok");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(500);
            status.setMsg("error");
        }
        return status;
    }

    @Override
    public ResponseStatus deleteBatchProcess(String[] ids) {
        ResponseStatus status = new ResponseStatus();
        try {
            for (String i : ids) {
                int delete = processMapper.deleteByPrimaryKey(i);
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
    public EasyUiDataGridResult<Process> search_Process_by_ProcessId(String pId, int page, int rows) {
        String id = "%" + pId + "%";
        EasyUiDataGridResult<Process> result = new EasyUiDataGridResult<>();

        PageHelper.startPage(page, rows);
        List<Process> technologyRequirements = processMapper.selectProcessById(id);

        PageInfo<Process> info = new PageInfo<>(technologyRequirements);
        int total = (int)info.getTotal();
        //int total = (int) requirementMapper.countByExampleByCondition(record);
        result.setRows(technologyRequirements);
        result.setTotal(total);
        return result;
    }

    @Override
    public EasyUiDataGridResult<Process> search_Process_by_tRId(String tPId, int page, int rows) {
        String id = "%" + tPId + "%";
        EasyUiDataGridResult<Process> result = new EasyUiDataGridResult<>();

        PageHelper.startPage(page, rows);
        List<Process> technologyRequirements = processMapper.selectProcessBytPId(id);

        PageInfo<Process> info = new PageInfo<>(technologyRequirements);
        int total = (int)info.getTotal();
        //int total = (int) requirementMapper.countByExampleByCondition(record);
        result.setRows(technologyRequirements);
        result.setTotal(total);
        return result;
    }
}
