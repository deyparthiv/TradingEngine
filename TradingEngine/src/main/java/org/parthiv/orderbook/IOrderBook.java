package org.parthiv.orderbook;

/**
 * Interface for the order book
 */
public interface IOrderBook {
    /**
     * @return the unique identifier of the security this order book is for
     */
    public String getSecurity();

    /**
     * @param visitor pattern for operations on the order book
     */
    public void accept(IOrderBookVisitor visitor);
}
