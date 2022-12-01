package cn.itcast.order.service;

import cn.itcas.feign.clients.UserClient;
import cn.itcas.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {



    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        //通过Feign发送Get请求得到User对象信息
        User user = userClient.getById(order.getUserId());
        //保存user到order
        order.setUser(user);
        // 4.返回
        return order;
    }
}
