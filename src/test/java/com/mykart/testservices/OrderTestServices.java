package com.mykart.testservices;

import com.mykart.exception.ResourceNotFound;
import com.mykart.model.Orders;
import com.mykart.repository.orders.OrderRepository;
import com.mykart.service.orders.OrderService;
import com.mykart.service.orders.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderTestServices {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderServiceImpl orderService;

    @Test
    public void  getAllOrdersTest() {
        Orders orders=mock(Orders.class);
        List<Orders> list=new ArrayList<Orders>();
        list.add(orders);
        when(orderRepository.findAllByUserId(101)).thenReturn(list);
        orderService.getAllOrders(101);
        verify(orderRepository,times(1)).findAllByUserId(101);

    }
    @Test
    public void getOrderByIdTest() throws ResourceNotFound {
        Orders orders=mock(Orders.class);
        when(orderRepository.findAllByUserIdAndOrderId(101,01)).thenReturn(orders);
        orderService.getOrderById(101,01);
        verify(orderRepository,times(1)).findAllByUserIdAndOrderId(101,01);

    }





}
