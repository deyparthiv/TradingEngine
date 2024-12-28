package org.parthiv.orderbook.orders;

import org.parthiv.orderbook.IOrderVisitor;

/**
 * Represents a market order yet to be processed by the order book
 */
public class MarketOrder implements IOrder {
    private final OrderCore orderCore;

    public MarketOrder(OrderCore orderCore) {
        this.orderCore = orderCore;
    }

    /**
     * @param visitor visitor for the visitor pattern
     */
    @Override
    public void accept(IOrderVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * @return unique identifier for an order
     */
    @Override
    public String getOrderId() {
        return orderCore.getOrderId();
    }

    /**
     * @return unique identifier for a security
     */
    @Override
    public String getSecurityId() {
        return orderCore.getSecurityId();
    }

    /**
     * @return unique identifier for the trader
     */
    @Override
    public String getUsername() {
        return orderCore.getUsername();
    }

    /**
     * @return
     */
    @Override
    public int getQuantity() {
        return 0;
    }
}
