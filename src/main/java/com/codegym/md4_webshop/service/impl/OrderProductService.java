package com.codegym.md4_webshop.service.impl;

import com.codegym.md4_webshop.model.Orders;
import com.codegym.md4_webshop.model.Product;
import com.codegym.md4_webshop.model.cart.Cart;
import com.codegym.md4_webshop.model.oderProduct.OrderProduct;
import com.codegym.md4_webshop.model.oderProduct.OrderProductID;
import com.codegym.md4_webshop.repository.OrderProductRepository;
import com.codegym.md4_webshop.repository.OrdersRepository;
import com.codegym.md4_webshop.repository.ProductRepository;
import com.codegym.md4_webshop.service.IOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService implements IOrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrdersRepository ordersRepository;
    @Override
    public Cart save(Cart item, Long idOrder) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(new OrderProductID(item.getProduct().getId(), idOrder));
        Orders orders = ordersRepository.findById(idOrder).get();
        orderProduct.setOrders(orders);
        orderProduct.setCount(item.getCount());
        Product product = productRepository.findById(item.getProduct().getId()).get();
        orderProduct.setProduct(product);
        orderProduct.setPrice(product.getPrice());
        orderProduct.setDiscount(product.getDiscount());
        this.orderProductRepository.save(orderProduct);
        return null;
    }

    @Override
    public Iterable<OrderProduct> findAllByOrders(Long idOrders) {
        return this.orderProductRepository.findByOrders_Id(idOrders);
    }
}
