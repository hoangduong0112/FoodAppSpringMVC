package com.hd.pojo;

import com.hd.pojo.MenuItems;
import com.hd.pojo.OrderSale;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-01T16:04:40")
@StaticMetamodel(OrderItems.class)
public class OrderItems_ { 

    public static volatile SingularAttribute<OrderItems, MenuItems> itemId;
    public static volatile SingularAttribute<OrderItems, Integer> quantity;
    public static volatile SingularAttribute<OrderItems, OrderSale> orderId;
    public static volatile SingularAttribute<OrderItems, Integer> id;

}