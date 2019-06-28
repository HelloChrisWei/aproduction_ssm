package com.cskaoyan.controller.scheduling;

import com.cskaoyan.exception.ProductException;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Product;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.scheduling.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    @ResponseBody
    public EasyUiDataGridResult<Product> product(int page, int rows) {
        return productService.selectAllProductByPage(page, rows);
    }

    @RequestMapping("/find")
    public String productList() {
        return "product_list";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Product> searchProductData() {
        return productService.selectAllProduct();
    }

    @RequestMapping("/add_judge")
    public String customAddJudge() {
        return "product_add";
    }

    @RequestMapping("/add")
    public String customAdd() {
        return "product_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResponseStatus productInsert(Product product) {
        return productService.insert(product);
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public ResponseStatus editJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("/edit")
    public String edit() {
        return "product_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public ResponseStatus updateAll(Product product) {
        return productService.updateByPrimaryKeySelective(product);
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public ResponseStatus updateNote(Product product) {
        return productService.updateByPrimaryKeySelective(product);
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatch(String[] ids) {
        try {
            return productService.deleteBatch(ids);
        } catch (ProductException e) {
            e.printStackTrace();
            ResponseStatus status = new ResponseStatus();
            status.setStatus(0);
            status.setMsg("删除产品失败！");
            return status;
        }
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public ResponseStatus deleteJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("/search_product_by_productId")
    @ResponseBody
    public EasyUiDataGridResult<Product> searchProductByProductId(String searchValue, int page, int rows) {
        return productService.searchProductByProductId(searchValue, page, rows);
    }

    @RequestMapping("/search_product_by_productName")
    @ResponseBody
    public EasyUiDataGridResult<Product> searchProductByProductName(String searchValue, int page, int rows) {
        return productService.searchProductByProductName(searchValue, page, rows);
    }

    @RequestMapping("/search_product_by_productType")
    @ResponseBody
    public EasyUiDataGridResult<Product> searchProductByProductType(String searchValue, int page, int rows) {
        return productService.searchProductByProductType(searchValue, page, rows);
    }

    @RequestMapping("/get/{productId}")
    @ResponseBody
    public Product searchProductDetail(@PathVariable("productId") String productId) {
        return productService.selectProductByProductId(productId);
    }


}
