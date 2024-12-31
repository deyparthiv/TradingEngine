package org.parthiv.orderbook.orders;

/**
 * Represents key information about an order
 */
public class OrderCore {
    private final String orderId, username, securityId;

    public OrderCore(String orderId, String username, String securityId) {
        this.orderId = orderId;
        this.username = username;
        this.securityId = securityId;
    }

    /**
     * @return unique identifier for an order
     */
    public String getOrderId() {
        return this.orderId;
    }
    /**
     * @return unique identifier for a security
     */
    public String getSecurityId() {
        return this.securityId;
    }

    /**
     * @return unique identifier for the trader
     */
    public String getUsername() {
        return this.username;
    }

}
