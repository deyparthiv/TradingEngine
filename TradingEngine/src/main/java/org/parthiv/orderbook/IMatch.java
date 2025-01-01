package org.parthiv.orderbook;

/**
 * Used to return the result of a match in the orderbook
 */
public interface IMatch {
    public OrderBookEntry getBid();
    public OrderBookEntry getAsk();
}
