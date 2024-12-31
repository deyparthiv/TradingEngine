package org.parthiv.orderbook.orders;

import org.parthiv.orderbook.IOrderVisitor;

/**
 * Representation of a limit order yet to be processed by order book
 */
public class LimitOrder implements ILimitOrder {
    final long price;
    final OrderCore orderCore;
    final boolean isBuySide;
    final int quantity;
    public LimitOrder(OrderCore orderCore, int quantity, long price, boolean isBuySide) {
        this.orderCore = orderCore;
        this.isBuySide = isBuySide;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * @return the requested price for the limit order
     */
    @Override
    public long getPrice() {
        return this.price;
    }

    /**
     * @return true if this limit order is a bid
     */
    @Override
    public boolean isBuySide() {
        return this.isBuySide;
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
     * @return quantity requested in the limit order
     */
    @Override
    public int getQuantity() {
       return this.quantity;
    }

    /**
     * @return
     */
    @Override
    public OrderCore getOrderCore() {
       return this.orderCore;
    }

    @Override
    public boolean equals(Object o){
        LimitOrder order = (LimitOrder)o;
        return order.getOrderId().equals(this.getOrderId());
    }
}
