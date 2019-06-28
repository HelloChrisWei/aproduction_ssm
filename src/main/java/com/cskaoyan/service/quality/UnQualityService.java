package com.cskaoyan.service.quality;

import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.pojo.UnqualifyApplyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * @version 1.0 2019/6/26
 * @author Wei
 */
public interface UnQualityService {

    List<UnqualifyApplyVO> getUnqualityList(@Param("page") int page, @Param("rows") int rows);

    int getTotalRecordNum();

    boolean deleteBatch(String[] ids);
}
