package com.mykart.service.cart;

import com.mykart.dto.ItemDTO;
import com.mykart.exception.ItemAlreadyPresentException;
import com.mykart.exception.OutOfStockException;
import com.mykart.exception.ResourceNotFound;
import com.mykart.model.Cart;
import com.mykart.model.User;
import com.mykart.repository.cart.CartRepository;
import com.mykart.service.item.ItemService;
import com.mykart.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
  @Autowired private CartRepository cartRepository;
  @Autowired private ItemService itemService;
  @Autowired private UserService userService;

  @Override
  public List<Cart> getAllItems(int userId) {
    List<ItemDTO> itemDTOList = new ArrayList<>();
    User user = userService.getUserById(userId);
    String cartId = user.getCartId();
    List<Cart> cartList = cartRepository.findByCartIdAndOrdered(cartId, 0);
    System.out.println(cartList);
    Iterator<Cart> iterator = cartList.iterator();
    while (iterator.hasNext()) {
      itemDTOList.add(itemService.getItem(iterator.next().getItemId()));
    }

    System.out.println(itemDTOList);

    return cartList;
  }

  @Override
  public Cart saveItem(int userId, Cart cart)
      throws OutOfStockException, ItemAlreadyPresentException {
    User user = userService.getUserById(userId);
    System.out.println("arrived at cart service");
    String cart_id = user.getCartId();
    ItemDTO item = itemService.getItem(cart.getItemId());
    Iterator<Cart> iterator = cartRepository.findByCartIdAndOrdered(cart_id, 0).iterator();
    while (iterator.hasNext()) {
      if (iterator.next().getItemId() == item.getItemId()) {
        throw new ItemAlreadyPresentException(
            item.getItemName() + " is already added to your cart");
      }
    }
    int inStock = item.getInStock();
    if (inStock < cart.getQuantity())
      throw new OutOfStockException(item.getItemName() + " is currently unavailable");
    cart.setItemId(item.getItemId());
    cart.setCartId(user.getCartId());
    cart.setPrice(item.getPrice() * cart.getQuantity());
    System.out.println(cart);
    return cartRepository.save(cart);
  }

  @Override
  public Boolean deleteItemById(int userId, Cart cart) throws ResourceNotFound {
    User user = userService.getUserById(userId);
    String cartId = user.getCartId();
    Cart c = cartRepository.findByCartIdAndItemIdAndIsOrdered(cartId, cart.getItemId(), 0);
    if (c == null) throw new ResourceNotFound();
    System.out.println(c);
    cartRepository.deleteById(c.getId());
    return true;
  }

  @Override
  public Cart updateItemById(int userId, Cart cart) throws ResourceNotFound, OutOfStockException {
    User user = userService.getUserById(userId);
    String cartId = user.getCartId();
    int itemId = cart.getItemId();
    Cart newCart = cartRepository.findByCartIdAndItemIdAndIsOrdered(cartId, itemId, 0);
    if (newCart == null) throw new ResourceNotFound("resource not found");

    ItemDTO item = itemService.getItem(cart.getItemId());
    int inStock = item.getInStock();

    if (inStock < cart.getQuantity())
      throw new OutOfStockException(item.getItemName() + " is currently unavailable");

    newCart.setQuantity(cart.getQuantity());
    cartRepository.save(newCart);
    return newCart;
  }
}
