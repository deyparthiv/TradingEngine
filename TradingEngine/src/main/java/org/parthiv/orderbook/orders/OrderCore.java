package org.parthiv.orderbook.orders;

public class OrderCore implements IOrderCore {
    private final String orderId, securityId, username;

    /**
     * @param orderId    unique identifier for the order
     * @param securityId unique identifier for the security
     * @param username   unique identifier for the trader
     */
    OrderCore(String orderId, String securityId, String username) {
        this.orderId = orderId;
        this.securityId = securityId;
        this.username = username;
    }

    /**
     * @return unique identifier for the order
     */
    @Override
    public String getOrderId() {
        return orderId;
    }

    /**
     * @return unique identifier for the security
     */
    @Override
    public String getSecurityId() {
        return securityId;
    }

    /**
     * @return unique identifier for the trader
     */
    @Override
    public String getUsername() {
        return username;
    }
}
