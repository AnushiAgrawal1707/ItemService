package com.mykart.service.orders;

import com.mykart.exception.ResourceNotFound;
import com.mykart.model.Cart;
import com.mykart.model.Orders;
import com.mykart.model.User;
import com.mykart.repository.orders.OrderRepository;
import com.mykart.service.cart.CartService;
import com.mykart.service.item.ItemServiceImpl;
import com.mykart.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderRepository repository;
    @Autowired
    private CartService cartService;
    @Autowired
    private ItemServiceImpl itemService;

    @Override
    public Orders placeOrder(int userId) {
        User user = userService.getUserById(userId);
        List<Cart> cartItems = cartService.getAllItems(userId);
        System.out.println(cartItems);
        Iterator<Cart> iterator = cartItems.iterator();
        Orders orders = new Orders();
        double bill=0;
        while (iterator.hasNext()){
            Cart cart = iterator.next();
            bill= bill+cart.getPrice();
            itemService.updateItem(cart.getItemId(),cart.getQuantity());
            cart.setIsOrdered(1);
        }
        orders.setCartId(user.getCartId());
        orders.setUserId(userId);
        orders.setTotalBill(bill);

        return repository.save(orders);
    }


    @Override
    public List<Orders> getAllOrders(int userId) {
        List<Orders> ordersList = repository.findAllByUserId(userId);

        return ordersList;
    }

    @Override
    public Orders getOrderById(int userId,int orderId) throws ResourceNotFound {
        Orders orders=repository.findAllByUserIdAndOrderId(userId,orderId);
        System.out.println(orders);
        if(orders==null)
            throw new ResourceNotFound();
        return orders;
    }

    @Override
    public String deleteOrder(int userId, int orderId) {

        repository.deleteById(orderId);
        return "order with order id "+orderId+" is deleted successfully";
    }
}
