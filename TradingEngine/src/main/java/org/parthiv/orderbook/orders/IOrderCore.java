package org.parthiv.orderbook.orders;

/**
 * interface for the key information about an order
 */
public interface IOrderCore {
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
}
