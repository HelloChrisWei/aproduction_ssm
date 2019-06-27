package com.cskaoyan.service.scheduling.impl;

import com.cskaoyan.exception.ProductException;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Product;
import com.cskaoyan.pojo.ProductExample;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.scheduling.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public EasyUiDataGridResult<Product> selectAllProductByPage(int page, int rows) {
        EasyUiDataGridResult<Product> result = new EasyUiDataGridResult<>();
        ProductExample example = new ProductExample();

        int total = (int) productMapper.countByExample(example);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<Product> products = productMapper.selectAllProductByPage(rows, offset);
        result.setRows(products);
        result.setTotal(total);
        return result;
    }

    @Override
    public ResponseStatus insert(Product product) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isAdd = productMapper.insertSelective(product);
            if (isAdd == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("该产品编号已存在，请更改产品编号，重新添加！");
        }
        return status;
    }

    @Override
    public ResponseStatus updateByPrimaryKeySelective(Product product) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isUpdate = productMapper.updateByPrimaryKeySelective(product);
            if (isUpdate == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("产品修改失败！请重试！");
        }
        return status;
    }

    @Override
    public ResponseStatus deleteBatch(String[] ids) throws ProductException {
        ResponseStatus status = new ResponseStatus();
        try {
            for (String id : ids) {
                productMapper.deleteByPrimaryKey(id);
            }
            status.setStatus(200);
            status.setMsg("OK");
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("产品批量删除失败，请重试！");
            throw new ProductException("产品批量删除失败，请重试！");
        }
        return status;
    }

    private EasyUiDataGridResult<Product> pageHandle(Product product, int rows, int page) {
        EasyUiDataGridResult<Product> result = new EasyUiDataGridResult<>();

        int total = productMapper.selectProductCountByCondition(product);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<Product> products = productMapper.selectProductByConditionByPage(product, rows, offset);
        result.setRows(products);
        result.setTotal(total);
        return result;
    }

    @Override
    public EasyUiDataGridResult<Product> searchProductByProductId(String productId, int page, int rows) {
        Product product = new Product();
        product.setProductId("%" + productId + "%");
        return pageHandle(product, rows, page);
    }

    @Override
    public EasyUiDataGridResult<Product> searchProductByProductName(String productName, int page, int rows) {
        Product product = new Product();
        product.setProductId("%" + productName + "%");
        return pageHandle(product, rows, page);
    }

    @Override
    public EasyUiDataGridResult<Product> searchProductByProductType(String productType, int page, int rows) {
        Product product = new Product();
        product.setProductId("%" + productType + "%");
        return pageHandle(product, rows, page);
    }

    @Override
    public Product selectProductByProductId(String productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<Product> selectAllProduct() {
        return productMapper.selectAllProduct();
    }
}
