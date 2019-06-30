package com.cskaoyan.service.TechnologyService;

import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Process;
import com.cskaoyan.pojo.ResponseStatus;

public interface ProcessService {
    EasyUiDataGridResult<Process> selectAllProcessByPage(int page, int rows);

    ResponseStatus insertProcess(Process record);

    ResponseStatus updateProcess(Process record);

    ResponseStatus deleteBatchProcess(String[] ids);

    EasyUiDataGridResult<Process> search_Process_by_ProcessId(String pId, int page, int rows);

    EasyUiDataGridResult<Process> search_Process_by_tRId(String tPId, int page, int rows);
}
