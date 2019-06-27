package com.cskaoyan.mapper;

import com.cskaoyan.pojo.Product;
import com.cskaoyan.pojo.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    // 自主添加接口
    List<Product> selectAllProductByPage(@Param("rows") int rows,@Param("offset") int offset);

    int selectProductCountByCondition(@Param("product") Product product);

    List<Product> selectProductByConditionByPage(@Param("custom") Product product, @Param("rows") int rows, @Param("offset") int offset);

    List<Product> selectAllProduct();
}