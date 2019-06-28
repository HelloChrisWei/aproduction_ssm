package com.cskaoyan.service.scheduling.impl;

import com.cskaoyan.annotation.ProceedTime;
import com.cskaoyan.exception.WorkException;
import com.cskaoyan.mapper.WorkMapper;
import com.cskaoyan.pojo.*;
import com.cskaoyan.pojo.Process;
import com.cskaoyan.service.scheduling.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkMapper workMapper;

    @Override
    @ProceedTime
    public EasyUiDataGridResult<WorkVO> selectAllWorkByPage(int page, int rows) {
        EasyUiDataGridResult<WorkVO> result = new EasyUiDataGridResult<>();
        WorkExample example = new WorkExample();

        int total = (int) workMapper.countByExample(example);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<WorkVO> works = workMapper.selectAllWorkByPage(rows, offset);
        result.setRows(works);
        result.setTotal(total);
        return result;
    }

    @Override
    @ProceedTime
    public ResponseStatus insert(Work work) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isAdd = workMapper.insertSelective(work);
            if (isAdd == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("该作业已存在，请更改作业编号，重新添加！");
        }
        return status;
    }

    @Override
    @ProceedTime
    public ResponseStatus updateByPrimaryKeySelective(Work work) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isUpdate = workMapper.updateByPrimaryKeySelective(work);
            if (isUpdate == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("作业修改失败！请重试！");
        }
        return status;
    }

    @Override
    @ProceedTime
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResponseStatus deleteBatch(String[] ids) throws WorkException {
        ResponseStatus status = new ResponseStatus();
        try {
            for (String id : ids) {
                workMapper.deleteByPrimaryKey(id);
            }
            status.setStatus(200);
            status.setMsg("OK");
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("订单批量删除失败，请重试！");
            throw new WorkException("订单批量删除失败，请重试！");
        }
        return status;
    }

    private EasyUiDataGridResult<WorkVO> pageHandle(WorkVO work, int rows, int page) {
        EasyUiDataGridResult<WorkVO> result = new EasyUiDataGridResult<>();

        int total = workMapper.selectWorkCountByCondition(work);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<WorkVO> works = workMapper.selectWorkByConditionByPage(work, rows, offset);
        result.setRows(works);
        result.setTotal(total);
        return result;
    }

    @Override
    @ProceedTime
    public EasyUiDataGridResult<WorkVO> searchWorkByWorkId(String workId, int page, int rows) {
        WorkVO work = new WorkVO();
        Product product = new Product();
        Device device = new Device();
        Process process = new Process();

        work.setWorkId("%" + workId + "%");
        work.setProduct(product);
        work.setDevice(device);
        work.setProcess(process);

        return pageHandle(work, rows, page);
    }

    @Override
    @ProceedTime
    public EasyUiDataGridResult<WorkVO> searchWorkByProductName(String productName, int page, int rows) {
        WorkVO work = new WorkVO();
        Product product = new Product();
        Device device = new Device();
        Process process = new Process();

        product.setProductName("%" + productName + "%");
        work.setProduct(product);
        work.setDevice(device);
        work.setProcess(process);

        return pageHandle(work, rows, page);
    }

    @Override
    @ProceedTime
    public EasyUiDataGridResult<WorkVO> searchWorkByDeviceName(String deviceName, int page, int rows) {
        WorkVO work = new WorkVO();
        Product product = new Product();
        Device device = new Device();
        Process process = new Process();

        device.setDeviceName("%" + deviceName + "%");
        work.setProduct(product);
        work.setDevice(device);
        work.setProcess(process);

        return pageHandle(work, rows, page);
    }

    @Override
    @ProceedTime
    public EasyUiDataGridResult<WorkVO> searchWorkByProcessId(String processId, int page, int rows) {
        WorkVO work = new WorkVO();
        Product product = new Product();
        Device device = new Device();
        Process process = new Process();

        process.setProcessId("%" + processId + "%");
        work.setProduct(product);
        work.setDevice(device);
        work.setProcess(process);

        return pageHandle(work, rows, page);
    }

    @Override
    @ProceedTime
    public WorkVO selectWorkByWorkId(String workId) {
        return workMapper.selectWorkByWorkId(workId);
    }

    @Override
    @ProceedTime
    public List<WorkVO> selectAllWork() {
        return workMapper.selectAllWork();
    }
}
