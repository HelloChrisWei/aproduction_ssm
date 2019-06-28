package com.cskaoyan.service.scheduling.impl;

import com.cskaoyan.annotation.ProceedTime;
import com.cskaoyan.exception.ManufactureException;
import com.cskaoyan.mapper.ManufactureMapper;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.scheduling.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManufactureServiceImpl implements ManufactureService {

    @Autowired
    private ManufactureMapper manufactureMapper;

    @Override
    @ProceedTime
    public EasyUiDataGridResult<ManufactureVO> selectAllManufactureByPage(int page, int rows) {
        EasyUiDataGridResult<ManufactureVO> result = new EasyUiDataGridResult<>();
        ManufactureExample example = new ManufactureExample();

        int total = (int) manufactureMapper.countByExample(example);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<ManufactureVO> manufactures = manufactureMapper.selectAllManufactureByPage(rows, offset);
        result.setRows(manufactures);
        result.setTotal(total);
        return result;
    }

    @Override
    @ProceedTime
    public ResponseStatus insert(Manufacture manufacture) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isAdd = manufactureMapper.insertSelective(manufacture);
            if (isAdd == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("该生产计划已存在，请更改生产计划编号，重新添加！");
        }
        return status;
    }

    @Override
    @ProceedTime
    public ResponseStatus updateByPrimaryKeySelective(Manufacture manufacture) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isUpdate = manufactureMapper.updateByPrimaryKeySelective(manufacture);
            if (isUpdate == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("生产计划修改失败！请重试！");
        }
        return status;
    }

    @Override
    @ProceedTime
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResponseStatus deleteBatch(String[] ids) throws ManufactureException {
        ResponseStatus status = new ResponseStatus();
        try {
            for (String id : ids) {
                manufactureMapper.deleteByPrimaryKey(id);
            }
            status.setStatus(200);
            status.setMsg("OK");
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("生产计划批量删除失败，请重试！");
            throw new ManufactureException("生产计划批量删除失败，请重试！");
        }
        return status;
    }

    private EasyUiDataGridResult<ManufactureVO> pageHandle(ManufactureVO manufacture, int rows, int page) {
        EasyUiDataGridResult<ManufactureVO> result = new EasyUiDataGridResult<>();

        int total = manufactureMapper.selectManufactureCountByCondition(manufacture);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<ManufactureVO> manufactures = manufactureMapper.selectManufactureByConditionByPage(manufacture, rows, offset);
        result.setRows(manufactures);
        result.setTotal(total);
        return result;
    }

    @Override
    @ProceedTime
    public EasyUiDataGridResult<ManufactureVO> searchManufactureByManufactureSn(String manufactureSn, int page, int rows) {
        ManufactureVO manufacture = new ManufactureVO();
        Order order = new Order();
        Technology technology = new Technology();

        manufacture.setManufactureSn("%" + manufactureSn + "%");
        manufacture.setOrder(order);
        manufacture.setTechnology(technology);

        return pageHandle(manufacture, rows, page);

    }

    @Override
    @ProceedTime
    public EasyUiDataGridResult<ManufactureVO> searchManufactureByOrderId(String orderId, int page, int rows) {
        ManufactureVO manufacture = new ManufactureVO();
        Order order = new Order();
        Technology technology = new Technology();

        order.setOrderId("%" + orderId + "%");
        manufacture.setOrder(order);
        manufacture.setTechnology(technology);

        return pageHandle(manufacture, rows, page);
    }

    @Override
    @ProceedTime
    public EasyUiDataGridResult<ManufactureVO> searchManufactureByTechnologyName(String technologyName, int page, int rows) {
        ManufactureVO manufacture = new ManufactureVO();
        Order order = new Order();
        Technology technology = new Technology();

        technology.setTechnologyName("%" + technologyName + "%");
        manufacture.setOrder(order);
        manufacture.setTechnology(technology);

        return pageHandle(manufacture, rows, page);
    }

    @Override
    @ProceedTime
    public ManufactureVO selectManufactureByManufactureSn(String manufactureSn) {
        return manufactureMapper.selectManufactureByManufactureSn(manufactureSn);
    }

    @Override
    @ProceedTime
    public List<ManufactureVO> selectAllManufacture() {
        return manufactureMapper.selectAllManufacture();
    }
}
