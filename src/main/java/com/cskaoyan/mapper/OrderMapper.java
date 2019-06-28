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

    // 自主创建
    List<OrderVO> selectAllOrderByPage(@Param("rows") int rows, @Param("offset") int offset);

    int selectOrderCountByCondition(@Param("order") OrderVO order);

    List<OrderVO> selectOrderByConditionByPage(@Param("order") OrderVO order, @Param("rows") int rows, @Param("offset") int offset);

    List<OrderVO> selectAllOrder();

    OrderVO selectOrderByOrderId(@Param("orderId") String orderId);
}
