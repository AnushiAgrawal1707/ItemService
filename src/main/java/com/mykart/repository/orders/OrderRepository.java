package com.mykart.repository.orders;

import com.mykart.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
    @Query("from Orders where userId=?1")
   public List<Orders> findAllByUserId(int userId);

    @Query("from Orders where order_id=?1")
   public Orders findAllByOrderId(int orderId);

    @Query("from Orders where userId=?1 and orderId=?2")
    Orders findAllByUserIdAndOrderId (int userId,int orderId);
}
