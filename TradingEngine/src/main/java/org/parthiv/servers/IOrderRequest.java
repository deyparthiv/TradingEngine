package org.parthiv.servers;

import org.parthiv.orderbook.IOrderVisitor;
import org.parthiv.orderbook.orders.IOrder;

public interface IOrderRequest {

    public IOrder getOrder();
    public IOrderVisitor getAction();
}

