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
     * @param reader visitor pattern for reading the order book
     */
    public void accept(IOrderBookReader reader);
}
