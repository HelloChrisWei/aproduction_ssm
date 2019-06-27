package com.cskaoyan.service.scheduling.impl;

import com.cskaoyan.exception.OrderException;
import com.cskaoyan.mapper.OrderMapper;
import com.cskaoyan.pojo.*;
import com.cskaoyan.service.scheduling.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public EasyUiDataGridResult<OrderVO> selectAllOrderByPage(int page, int rows) {
        EasyUiDataGridResult<OrderVO> result = new EasyUiDataGridResult<>();
        OrderExample example = new OrderExample();

        int total = (int) orderMapper.countByExample(example);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<OrderVO> orders = orderMapper.selectAllOrderByPage(rows, offset);
        result.setRows(orders);
        result.setTotal(total);
        return result;
    }

    @Override
    public ResponseStatus insert(Order order) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isAdd = orderMapper.insertSelective(order);
            if (isAdd == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("该订单已存在，请更改订单编号，重新添加！");
        }
        return status;
    }

    @Override
    public ResponseStatus updateByPrimaryKeySelective(Order order) {
        ResponseStatus status = new ResponseStatus();
        try {
            int isUpdate = orderMapper.updateByPrimaryKeySelective(order);
            if (isUpdate == 1) {
                status.setStatus(200);
                status.setMsg("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("订单修改失败！请重试！");
        }
        return status;
    }

    @Override
    public ResponseStatus deleteBatch(String[] ids) throws OrderException {
        ResponseStatus status = new ResponseStatus();
        try {
            for (String id : ids) {
                orderMapper.deleteByPrimaryKey(id);
            }
            status.setStatus(200);
            status.setMsg("OK");
        } catch (Exception e) {
            e.printStackTrace();
            status.setStatus(0);
            status.setMsg("订单批量删除失败，请重试！");
            throw new OrderException("订单批量删除失败，请重试！");
        }
        return status;
    }

    private EasyUiDataGridResult<OrderVO> pageHandle(OrderVO order, int rows, int page) {
        EasyUiDataGridResult<OrderVO> result = new EasyUiDataGridResult<>();

        int total = orderMapper.selectOrderCountByCondition(order);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<OrderVO> orders = orderMapper.selectOrderByConditionByPage(order, rows, offset);
        result.setRows(orders);
        result.setTotal(total);
        return result;
    }

    @Override
    public EasyUiDataGridResult<OrderVO> searchOrderByOrderId(String orderId, int page, int rows) {
        OrderVO order = new OrderVO();
        Custom custom = new Custom();
        Product product = new Product();

        order.setOrderId("%" + orderId + "%");
        order.setCustom(custom);
        order.setProduct(product);

        return pageHandle(order, rows, page);
    }

    @Override
    public EasyUiDataGridResult<OrderVO> searchOrderByCustomName(String customName, int page, int rows) {
        OrderVO order = new OrderVO();
        Custom custom = new Custom();
        Product product = new Product();

        custom.setCustomName("%" + customName + "%");
        order.setCustom(custom);
        order.setProduct(product);

        return pageHandle(order, rows, page);
    }

    @Override
    public EasyUiDataGridResult<OrderVO> searchOrderByProductName(String productName, int page, int rows) {
        OrderVO order = new OrderVO();
        Custom custom = new Custom();
        Product product = new Product();

        product.setProductName("%" + productName + "%");
        order.setCustom(custom);
        order.setProduct(product);

        return pageHandle(order, rows, page);
    }

    @Override
    public OrderVO selectOrderByOrderId(String orderId) {
        return orderMapper.selectOrderByOrderId(orderId);
    }

    @Override
    public List<OrderVO> selectAllOrder() {
        return orderMapper.selectAllOrder();
    }

}
