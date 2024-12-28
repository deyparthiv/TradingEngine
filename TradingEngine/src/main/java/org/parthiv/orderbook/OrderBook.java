package org.parthiv.orderbook;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Internal representation of an order book for a security
 */
public class OrderBook implements IOrderBook {
    final String security;
    final ConcurrentMap<String, OrderBookEntry> orderBookEntries;
    final SortedMap<Long, PriceLevel> bids;
    final SortedMap<Long, PriceLevel> asks;
    public OrderBook(String security) {
        this.security = security;
        orderBookEntries = new ConcurrentHashMap<>();
        //sort asks in ascending order
        this.asks = Collections.synchronizedSortedMap(new TreeMap<>());
        //sort bids in descending order
        this.bids = Collections.synchronizedSortedMap(new TreeMap<>((
                (o1, o2) -> -1 * Long.compare(o1, o2))));
    }

    /**
     * @return the security associated with this order book
     */
    @Override
    public String getSecurity() {
        return security;
    }

    /**
     * @param visitor pattern for operations on the order book
     */
    @Override
    public void accept(IOrderBookVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * for testing purposes
     * @param orderId
     * @return
     */
    public boolean containsOrder(String orderId){
        return orderBookEntries.containsKey(orderId);
    }
}
