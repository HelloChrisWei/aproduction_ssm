package com.cskaoyan.service.scheduling;

import com.cskaoyan.exception.OrderException;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Order;
import com.cskaoyan.pojo.OrderVO;
import com.cskaoyan.pojo.ResponseStatus;

import java.util.List;

public interface OrderService {

    /**
     * 通过分页的方式查询订单
     *
     * @param page 页
     * @param rows 行
     * @return 返回数据
     */
    EasyUiDataGridResult<OrderVO> selectAllOrderByPage(int page, int rows);

    /**
     * 新增订单
     *
     * @param order 订单
     * @return 返回数据
     */
    ResponseStatus insert(Order order);

    /**
     * 根据选择字段修改订单
     *
     * @param order 订单
     * @return 返回值
     */
    ResponseStatus updateByPrimaryKeySelective(Order order);

    /**
     * 批量删除订单
     *
     * @param ids 订单id
     * @return 返回值
     */
    ResponseStatus deleteBatch(String[] ids) throws OrderException;

    /**
     * 根据订单id查询订单
     *
     * @param orderId 订单id
     * @param page    页
     * @param rows    行
     * @return 返回值
     */
    EasyUiDataGridResult<OrderVO> searchOrderByOrderId(String orderId, int page, int rows);

    /**
     * 根据客户姓名查询订单
     *
     * @param customName 客户姓名
     * @param page       页
     * @param rows       行
     * @return 返回值
     */
    EasyUiDataGridResult<OrderVO> searchOrderByCustomName(String customName, int page, int rows);

    /**
     * 根据产品名称查询订单
     *
     * @param productName 产品名称
     * @param page        页
     * @param rows        行
     * @return 返回值
     */
    EasyUiDataGridResult<OrderVO> searchOrderByProductName(String productName, int page, int rows);

    /**
     * 根据主键orderId查询订单信息
     *
     * @param orderId 订单id
     * @return 订单
     */
    OrderVO selectOrderByOrderId(String orderId);

    /**
     * 查询到所有的订单
     *
     * @return 订单集合
     */
    List<OrderVO> selectAllOrder();

}
