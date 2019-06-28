package com.cskaoyan.service.scheduling;

import com.cskaoyan.exception.ManufactureException;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Manufacture;
import com.cskaoyan.pojo.ManufactureVO;
import com.cskaoyan.pojo.ResponseStatus;

import java.util.List;

public interface ManufactureService {

    EasyUiDataGridResult<ManufactureVO> selectAllManufactureByPage(int page, int rows);

    ResponseStatus insert(Manufacture manufacture);

    ResponseStatus updateByPrimaryKeySelective(Manufacture manufacture);

    ResponseStatus deleteBatch(String[] ids) throws ManufactureException;

    EasyUiDataGridResult<ManufactureVO> searchManufactureByManufactureSn(String manufactureSn, int page, int rows);

    EasyUiDataGridResult<ManufactureVO> searchManufactureByOrderId(String orderId, int page, int rows);

    EasyUiDataGridResult<ManufactureVO> searchManufactureByTechnologyName(String technologyName, int page, int rows);

    ManufactureVO selectManufactureByManufactureSn(String manufactureSn);

    List<ManufactureVO> selectAllManufacture();


}
