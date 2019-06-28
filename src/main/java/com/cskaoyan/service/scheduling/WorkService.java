package com.cskaoyan.service.scheduling;

import com.cskaoyan.exception.WorkException;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.pojo.Work;
import com.cskaoyan.pojo.WorkVO;

import java.util.List;

public interface WorkService {

    EasyUiDataGridResult<WorkVO> selectAllWorkByPage(int page, int rows);

    ResponseStatus insert(Work work);

    ResponseStatus updateByPrimaryKeySelective(Work work);

    ResponseStatus deleteBatch(String[] ids) throws WorkException;

    EasyUiDataGridResult<WorkVO> searchWorkByWorkId(String workId, int page, int rows);

    EasyUiDataGridResult<WorkVO> searchWorkByProductName(String productName, int page, int rows);

    EasyUiDataGridResult<WorkVO> searchWorkByDeviceName(String deviceName, int page, int rows);

    EasyUiDataGridResult<WorkVO> searchWorkByProcessId(String processId, int page, int rows);

    WorkVO selectWorkByWorkId(String workId);

    List<WorkVO> selectAllWork();


}
