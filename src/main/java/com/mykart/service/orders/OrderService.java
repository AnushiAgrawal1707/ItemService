package com.mykart.service.orders;

import com.mykart.exception.ResourceNotFound;
import com.mykart.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {

    public Orders placeOrder(int userId);
    public List<Orders> getAllOrders(int userId);
    public Orders getOrderById(int userId,int orderId) throws ResourceNotFound;
    public String deleteOrder(int userId, int orderId);
}
