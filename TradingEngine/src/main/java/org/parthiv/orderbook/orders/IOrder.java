package org.parthiv.orderbook.orders;

import org.parthiv.orderbook.orders.visitors.IOrderVisitor;

public interface IOrder {
    public void accept(IOrderVisitor visitor);
}
