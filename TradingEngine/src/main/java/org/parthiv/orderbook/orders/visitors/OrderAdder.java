package org.parthiv.orderbook.orders.visitors;

import org.parthiv.orderbook.IOrderBookWriter;
import org.parthiv.orderbook.orders.LimitOrder;
import org.parthiv.orderbook.orders.MarketOrder;
import org.parthiv.orderbook.orders.visitors.IOrderVisitor;

public class OrderAdder implements IOrderVisitor, IOrderBookWriter {
    /**
     * @param order
     */
    @Override
    public void visit(LimitOrder order) {

    }

    /**
     * @param order
     */
    @Override
    public void visit(MarketOrder order) {

    }
}
