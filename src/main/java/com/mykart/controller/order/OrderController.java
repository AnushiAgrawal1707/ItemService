package com.mykart.controller.order;


import com.mykart.exception.ResourceNotFound;
import com.mykart.model.Orders;
import com.mykart.model.User;
import com.mykart.service.orders.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.hibernate.cache.spi.entry.StructuredCacheEntry;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * to get details of a particular order
     * @param userId Identification of this user
     * @param orderId Order id for this user
     * @return Order of this id
     * @throws ResourceNotFound when order of this id is not found
     */
    @GetMapping("{userId}/orders/{order_id}")
    @ApiOperation(value = "Get a particular order detail")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    public Orders getOrderById(@ApiParam(value = "user id",required = true) @PathVariable("userId") int userId,@ApiParam(value = "order id",required = true) @PathVariable("orderId") int orderId) throws ResourceNotFound {
        return  orderService.getOrderById(userId,orderId);
    }

    /**
     * to get all the orders for the this user
     * @param userId Identification of this user
     * @return List of all Orders placed
     */
    @GetMapping("/{userId}/orders")
    @ApiOperation(value = "Get list of all Order for a user", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    public List<Orders> getAllOrders(@ApiParam(value="user id",required = true) @PathVariable("userId") int userId)
    {
        return orderService.getAllOrders(userId);
    }


    /**
     * to cancel a particular order detail
     * @param userId Identification of this user
     * @param orderId Order id for this user
     * @return String response for successful deletion
     * @throws ResourceNotFound
     */
    @DeleteMapping("{userId}/orders/{orderId}")
    @ApiOperation(value = "Cancel a particular order detail")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    public String deleteOrderById(@ApiParam(value = "user id",required = true) @PathVariable("userId") int userId,@ApiParam(value = "order id",required = true) @PathVariable("orderId") int orderId) throws ResourceNotFound {
        return  orderService.deleteOrder(userId,orderId);
    }


    /**
     *to place  a particular order
     * @param userId  Identification of this user
     * @return Order of this id
     */
    @PostMapping("{userId}/orders")
    @ApiOperation(value = "Place  a particular order ")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    public Orders placeOrder(@ApiParam(value="user id",required=true) @PathVariable("userId") int userId)
    {
        return orderService.placeOrder(userId);
    }

}
