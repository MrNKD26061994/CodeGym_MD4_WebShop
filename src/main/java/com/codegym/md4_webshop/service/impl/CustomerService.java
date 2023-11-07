package com.codegym.md4_webshop.service.impl;

import com.codegym.md4_webshop.controller.CartController;
import com.codegym.md4_webshop.controller.OrderProductController;
import com.codegym.md4_webshop.controller.OrdersController;
import com.codegym.md4_webshop.dto.CustomerPayDTO;
import com.codegym.md4_webshop.dto.OrderProductDTO;
import com.codegym.md4_webshop.model.Orders;
import com.codegym.md4_webshop.model.cart.Cart;
import com.codegym.md4_webshop.model.cart.CartID;
import com.codegym.md4_webshop.model.oderProduct.OrderProduct;
import com.codegym.md4_webshop.service.ICustomerService;
import com.codegym.md4_webshop.service.IOrderProductService;
import com.codegym.md4_webshop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private OrdersController ordersController;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderProductController orderProductController;

    @Autowired
    private IOrderProductService orderProductService;

    @Autowired
    private IProductService productService;

    @Autowired
    private CartController cartController;

    @Override
    @Transactional
    public void pay(CustomerPayDTO customerPayDTO) {
        Orders orders = new Orders();
        orders.setUser(customerPayDTO.getUser());
        orders.setPay(customerPayDTO.getPay());
        orders.setAddress(customerPayDTO.getAddress());
        orders = ordersService.save(orders);
//        orders = ordersController.create(orders).getBody();

//        OrderProductDTO orderProductDTO = new OrderProductDTO();
//        orderProductDTO.setCartList(customerPayDTO.getCartList());
        assert orders != null;
//        orderProductDTO.setIdOrders(orders.getId());
//        orderProductController.create(orderProductDTO);

        for (Cart item : customerPayDTO.getCartList()) {
            orderProductService.save(item, orders.getId());
            productService.reduceQuantity(item.getProduct().getId(), item.getCount());
        }

        for (Cart item : customerPayDTO.getCartList()) {
            cartController.delete(new CartID(item.getProduct().getId(), item.getUser().getId()));
        }
    }

    @Override
    @Transactional
    public void cancel(Long idOrders) {
        Iterable<OrderProduct> list = orderProductService.findAllByOrders(idOrders);
        for (OrderProduct item : list) {
//            orderProductService.remove(item.getId());
            productService.reduceQuantity(item.getProduct().getId(), - item.getCount());
        }
        ordersService.remove(idOrders);
    }
}
