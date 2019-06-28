package com.cskaoyan.service.material;

import com.cskaoyan.exception.MaterialReceiveException;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.MaterialReceive;
import com.cskaoyan.pojo.MaterialReceiveVO;
import com.cskaoyan.pojo.ResponseStatus;

import java.util.List;

public interface MaterialReceiveService {

    EasyUiDataGridResult<MaterialReceiveVO> selectAllMaterialReceiveByPage(int page, int rows);

    ResponseStatus insert(MaterialReceive materialReceive);

    ResponseStatus updateByPrimaryKeySelective(MaterialReceive materialReceive);

    ResponseStatus deleteBatch(String[] ids) throws MaterialReceiveException;

    EasyUiDataGridResult<MaterialReceiveVO> searchMaterialReceiveByReceiveId(String receiveId, int page, int rows);

    EasyUiDataGridResult<MaterialReceiveVO> searchMaterialReceiveByMaterialId(String materialId, int page, int rows);

    MaterialReceiveVO selectMaterialReceiveByReceiveId(String receiveId);

    List<MaterialReceiveVO> selectAllMaterialReceive();

}
