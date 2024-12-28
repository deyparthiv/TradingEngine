package org.parthiv.orderbook;

import java.security.Security;
import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Internal representation of an order book for a security
 */
public class OrderBook implements IOrderBook {
    final String security;
    final ConcurrentMap<String, OrderBookEntry> orderBookEntries;

    final SortedSet<PriceLevel> bids;
    final SortedSet<PriceLevel> asks;
    public OrderBook(String security){
        //sort asks in ascending order
        this.asks = Collections.synchronizedSortedSet(new TreeSet<>(
                Comparator.comparingLong(PriceLevel::getPrice))
        );
        //sort bids in descending order
        this.bids = Collections.synchronizedSortedSet(new TreeSet<>(
                (o1, o2) -> -1*Long.compare(o1.getPrice(),o2.getPrice()))
        );
    }


    /**
     * @return
     */
    @Override
    public String getSecurity() {
        return null;
    }

    /**
     * @param visitor pattern for operations on the order book
     */
    @Override
    public void accept(IOrderBookVisitor visitor) {

    }
}
