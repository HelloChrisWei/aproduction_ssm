package com.cskaoyan.mapper;

import com.cskaoyan.pojo.Order;
import com.cskaoyan.pojo.OrderExample;
import java.util.List;

import com.cskaoyan.pojo.OrderVO;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /**
     * 通过分页查询所有的订单
     *
     * @param rows   行
     * @param offset 偏移量
     * @return 分页展示的订单
     */
    List<OrderVO> selectAllOrderByPage(@Param("rows") int rows, @Param("offset") int offset);

    /**
     * 根据指定条件查询订单数量
     *
     * @param order 订单
     * @return 订单数量
     */
    int selectOrderCountByCondition(@Param("order") OrderVO order);

    /**
     * 根据指定条件查询订单
     *
     * @param order  订单
     * @param rows   行
     * @param offset 偏移量
     * @return 查询到的订单
     */
    List<OrderVO> selectOrderByConditionByPage(@Param("order") OrderVO order, @Param("rows") int rows, @Param("offset") int offset);

    /**
     * 查询到所有的订单
     *
     * @return 所有订单
     */
    List<OrderVO> selectAllOrder();

    OrderVO selectOrderByOrderId(@Param("orderId") String orderId);
}