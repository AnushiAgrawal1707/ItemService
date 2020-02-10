package com.mykart.repository.cart;

import com.mykart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart , Integer> {

    @Query("from Cart where cartId=?1 and isOrdered=?2")
    List<Cart> findByCartIdAndOrdered(String cartId, int check);


    @Query("from Cart where cartId=?1 and itemId=?2 and isOrdered=?3")
    Cart findByCartIdAndItemIdAndIsOrdered(String cartId, int itemId, int check);
}
