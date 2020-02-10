package com.mykart.controller.cart;

import com.mykart.dto.CartDTO;
import com.mykart.exception.ItemAlreadyPresentException;
import com.mykart.exception.OutOfStockException;
import com.mykart.exception.ResourceNotFound;
import com.mykart.model.Cart;
import com.mykart.service.cart.CartService;
import com.mykart.validators.Identification;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author anuja_harane
 *
 * CartController is responsible for cart related operations
 *
 */
@RestController
@RequestMapping("/v1/users")
@Log4j2
@Validated
@Api(value = "Cart Data Service",
        description = "Operations pertaining to Cart in Cart Data Service")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     *    to get all the items from the cart with given user identifier
     * @param userId  Identifier of user
     * @return      List of ItemDTO
     */
    @GetMapping("/{userId}/carts")
    @ApiOperation(value = "Get list of Items available in cart", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    public List<Cart> getAllItems(@ApiParam(value = "User id", required = true) @PathVariable("userId") @Identification int userId) {
        log.debug("Executed CartController.getAllItems() to retrieve all Items of  Cart");
        return cartService.getAllItems(userId);
    }


    /**
     *
     * @param userId    Identifier of user
     * @param cart       Cart object with item_id and quantity of item
     * @return           Cart
     */
    @PostMapping("/{userId}/carts")
    @ApiOperation(value = "Save Item object into Cart", response = Cart.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    public Cart addItemToCart(
            @ApiParam(value = "User id", required = true) @PathVariable("userId") @Identification int userId,
            @ApiParam(value = "Cart object", required = true) @RequestBody Cart cart) throws OutOfStockException, ItemAlreadyPresentException {
        log.debug("Executed CartController.addItemToCart(cart) to save Item to cart ");
        //System.out.println("arrived at cart controller");
        return cartService.saveItem(userId,cart);
    }

    /**
     *
     * @param userId  Identifier of User
     * @param cart     Cart object with item_id and quantity
     * @return      Cart
     */
    @PutMapping("/{userId}/carts")
    @ApiOperation(value = "Update cart object into the database", response = Cart.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    public Cart updateItemInCart(
            @ApiParam(value = "User id", required = true) @PathVariable("userId") @Identification int userId,
            @ApiParam(value = "Cart object", required = true) @RequestBody Cart cart) throws ResourceNotFound, OutOfStockException {
        log.debug("Executed CartController.updateItemInCart(cart) to update Item to cart ");
      //  System.out.println("arrived at cart controller");
        return cartService.updateItemById(userId,cart);
    }

    /**
     *
     * @param userId  Identifier of user
     * @param cart Cart object conating item id to be deleted
     * @return
     * @throws ResourceNotFound
     */
    @DeleteMapping("/{userId}/carts")
    @ApiOperation(value = "Delete cart object into the database", response = Cart.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    public Boolean deleteItemInCart(
            @ApiParam(value = "User id", required = true) @PathVariable("userId") @Identification int userId,
            @ApiParam(value = "cart", required = true) @RequestBody Cart cart) throws ResourceNotFound {
        log.debug("Executed CartController.updateItemInCart(cart) to update Item to cart ");
      //  System.out.println("arrived at cart controller");
        return cartService.deleteItemById(userId,cart);
    }
}

