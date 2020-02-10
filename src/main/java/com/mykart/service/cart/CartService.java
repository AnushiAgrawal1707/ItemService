package com.mykart.service.cart;

import com.mykart.dto.ItemDTO;
import com.mykart.exception.ItemAlreadyPresentException;
import com.mykart.exception.OutOfStockException;
import com.mykart.exception.ResourceNotFound;
import com.mykart.model.Cart;

import java.util.List;

public interface CartService {
    public List<Cart> getAllItems(int userId);
    public Cart saveItem(int userId,Cart cart) throws OutOfStockException, ItemAlreadyPresentException;
    public Cart updateItemById(int userId,Cart cart) throws ResourceNotFound, OutOfStockException;
    public Boolean deleteItemById(int userId,Cart cart) throws ResourceNotFound;
   
}
