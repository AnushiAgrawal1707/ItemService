package com.mykart.testcontroller;

import com.mykart.controller.order.OrderController;
import com.mykart.exception.ResourceNotFound;
import com.mykart.model.Orders;
import com.mykart.model.User;
import com.mykart.service.orders.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class OrderTestController {

    @Mock
    OrderService orderService;
    @InjectMocks
    OrderController orderController;

    @Test
    public void getAllItemsTest()
    {
        Orders order=mock(Orders.class);
        List<Orders> list=new ArrayList<>();
        list.add(order);
        when(orderService.getAllOrders(101)).thenReturn(list);
        orderController.getAllOrders(101);
        verify(orderService,times(1)).getAllOrders(101);
    }
    @Test
    public void getOrderByIdTest() throws ResourceNotFound {
        Orders order=mock(Orders.class);
        when(orderService.getOrderById(101,1)).thenReturn(order);
        orderController.getOrderById(101,01);
        verify(orderService,times(1)).getOrderById(101,01);

    }
    @Test
    public void cancelOrderTest() throws ResourceNotFound {
        Orders order=mock(Orders.class);
        when(orderService.getOrderById(101,01)).thenReturn(order);
        when(orderService.deleteOrder(101,01)).thenReturn("Order successfully canceled");
        orderController.deleteOrderById(101,01);
        verify(orderService,times(2)).deleteOrder(101,01);
    }
    @Test
    public void placeOrderTest()
    {
        Orders orders =mock(Orders.class);

        when(orderService.placeOrder(101)).thenReturn(orders);
        orderController.placeOrder(101);
        verify(orderService,times(1)).placeOrder(101);

    }

}
