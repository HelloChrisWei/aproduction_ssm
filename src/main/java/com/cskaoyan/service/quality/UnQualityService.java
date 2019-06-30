package com.cskaoyan.service.quality;

import com.cskaoyan.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * @version 1.0 2019/6/26
 * @author Wei
 */
public interface UnQualityService {

    EasyUiDataGridResult getUnqualityList(@Param("page") int page, @Param("rows") int rows);

    int getTotalRecordNum();

    boolean deleteBatch(String[] ids);

    ResponseStatus updateByPrimaryKeySelective(UnqualifyApply unqualifyApply);

    ResponseStatus updateByPrimaryKey(UnqualifyApply record);

    EasyUiDataGridResult searchById(String unqualifyApplyId, int page, int rows);

    EasyUiDataGridResult selectByExample(UnqualifyApplyVO unqualifyApplyVOExample, int page, int rows);

    ResponseStatus insert(UnqualifyApply record);
}
