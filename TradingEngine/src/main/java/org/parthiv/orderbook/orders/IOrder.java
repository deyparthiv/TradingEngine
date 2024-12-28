package org.parthiv.orderbook.orders;

import org.parthiv.orderbook.IOrderVisitor;

public interface IOrder {
    /**
     * @param visitor visitor for the visitor pattern
     */
    public void accept(IOrderVisitor visitor);

    /**
     * @return unique identifier for an order
     */
    public String getOrderId();

    /**
     * @return unique identifier for a security
     */
    public String getSecurityId();

    /**
     * @return unique identifier for the trader
     */
    public String getUsername();

    public int getQuantity();
}
