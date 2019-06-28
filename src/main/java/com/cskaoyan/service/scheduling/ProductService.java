package com.cskaoyan.service.scheduling;

import com.cskaoyan.exception.ProductException;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Product;
import com.cskaoyan.pojo.ResponseStatus;

import java.util.List;

public interface ProductService {

    EasyUiDataGridResult<Product> selectAllProductByPage(int page, int rows);

    ResponseStatus insert(Product product);

    ResponseStatus updateByPrimaryKeySelective(Product product);

    ResponseStatus deleteBatch(String[] ids) throws ProductException;

    EasyUiDataGridResult<Product> searchProductByProductId(String productId, int page, int rows);

    EasyUiDataGridResult<Product> searchProductByProductName(String productName, int page, int rows);

    EasyUiDataGridResult<Product> searchProductByProductType(String productType, int page, int rows);

    Product selectProductByProductId(String productId);

    List<Product> selectAllProduct();

}
