package com.codegym.md4_webshop.model.oderProduct;

import com.codegym.md4_webshop.model.Orders;
import com.codegym.md4_webshop.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_order")
public class OrderProduct {
    @EmbeddedId
    private OrderProductID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @MapsId("productID")
    private Product product;

    @ManyToOne
<<<<<<< HEAD
    @JoinColumn(name = "order_id")
    @MapsId("orderID")
<<<<<<< HEAD
<<<<<<< HEAD
    private Orders order;
=======
    private Orders orders;
>>>>>>> 1abe4a048cbbd111dbca37fa8a2b8211758c6243
=======
    @JoinColumn(name = "orders_id")
    @MapsId("ordersID")
    private Orders orders;
>>>>>>> 5484502c5ae5e679d4e1c218d70608a27bbd7adb
=======
    private Orders order;
>>>>>>> 51ffc333e05494a32fb8826e33147bb2f19c76c2

    private int count;
    private double price;
    private int discount;
}
