package com.cskaoyan.service.material;

import com.cskaoyan.exception.MaterialException;
import com.cskaoyan.pojo.Material;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.ResponseStatus;

import java.util.List;

public interface MaterialService {

    EasyUiDataGridResult<Material> selectAllMaterialByPage(int page, int rows);

    ResponseStatus insert(Material Material);

    ResponseStatus updateByPrimaryKeySelective(Material material);

    ResponseStatus deleteBatch(String[] ids) throws MaterialException;

    EasyUiDataGridResult<Material> searchMaterialByMaterialId(String materialId, int page, int rows);

    EasyUiDataGridResult<Material> searchMaterialByMaterialType(String materialType, int page, int rows);

    Material selectMaterialByMaterialId(String materialId);

    List<Material> selectAllMaterial();

}
