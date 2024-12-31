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
    public final SortedMap<Long, PriceLevel> bids;
    public final SortedMap<Long, PriceLevel> asks;
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
     * @param reader pattern for operations on the order book
     */
    @Override
    public void accept(IOrderBookReader reader) {
        reader.read(this);
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
