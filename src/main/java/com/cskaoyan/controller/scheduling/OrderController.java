package com.cskaoyan.controller.scheduling;

import com.cskaoyan.exception.OrderException;
import com.cskaoyan.pojo.EasyUiDataGridResult;
import com.cskaoyan.pojo.Order;
import com.cskaoyan.pojo.OrderVO;
import com.cskaoyan.pojo.ResponseStatus;
import com.cskaoyan.service.scheduling.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/list")
    @ResponseBody
    public EasyUiDataGridResult<OrderVO> order(int page, int rows) {
        return orderService.selectAllOrderByPage(page, rows);
    }

    @RequestMapping("/find")
    public String orderList() {
        return "order_list";
    }

    @RequestMapping("/add_judge")
    public String orderAddJudge() {
        return "order_add";
    }

    @RequestMapping("/add")
    public String orderAdd() {
        return "order_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResponseStatus orderInsert(Order order) {
        return orderService.insert(order);
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public ResponseStatus editJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("/edit")
    public String edit() {
        return "order_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public ResponseStatus updateAll(Order order) {
        return orderService.updateByPrimaryKeySelective(order);
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public ResponseStatus updateNote(Order order) {
        return orderService.updateByPrimaryKeySelective(order);
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public ResponseStatus deleteBatch(String[] ids) {
        try {
            return orderService.deleteBatch(ids);
        } catch (OrderException e) {
            e.printStackTrace();
            ResponseStatus status = new ResponseStatus();
            status.setStatus(0);
            status.setMsg("删除订单失败！");
            return status;
        }
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public ResponseStatus deleteJudge() {
        return new ResponseStatus();
    }

    @RequestMapping("/search_order_by_orderId")
    @ResponseBody
    public EasyUiDataGridResult<OrderVO> searchOrderById(String searchValue,int page, int rows){
        return orderService.searchOrderByOrderId(searchValue,page,rows);
    }

    @RequestMapping("/search_order_by_orderCustom")
    @ResponseBody
    public EasyUiDataGridResult<OrderVO> searchOrderByCustomName(String searchValue,int page, int rows){
        return orderService.searchOrderByCustomName(searchValue,page,rows);
    }

    @RequestMapping("/search_order_by_orderProduct")
    @ResponseBody
    public EasyUiDataGridResult<OrderVO> searchOrderByProductName(String searchValue, int page, int rows){
        return orderService.searchOrderByProductName(searchValue,page,rows);
    }

    @RequestMapping("/get/{orderId}")
    @ResponseBody
    public OrderVO searchOrderDetail(@PathVariable("orderId") String orderId){
        return orderService.selectOrderByOrderId(orderId);
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<OrderVO> searchOrderData(){
        return orderService.selectAllOrder();
    }

}
