package org.parthiv.orderbook;

import org.parthiv.orderbook.orders.LimitOrder;
import org.parthiv.orderbook.orders.MarketOrder;

public interface IOrderVisitor {
    public void visit(LimitOrder order);
    public void visit(MarketOrder order);
}
