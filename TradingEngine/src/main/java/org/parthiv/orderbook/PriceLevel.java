package org.parthiv.orderbook;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Price level
 */
public class PriceLevel {
    final static int DEFAULT_PRICE_LEVEL_QUEUE_STARTING_SIZE = 1;
    private final long price;
    final PriorityBlockingQueue<OrderBookEntry> ordersAtPriceLevel;
    public PriceLevel(long price){
        this.price = price;
        ordersAtPriceLevel = new PriorityBlockingQueue<>(DEFAULT_PRICE_LEVEL_QUEUE_STARTING_SIZE);
    }
    /**
     * @return the price this price level is for
     */
    public long getPrice(){
        return this.price;
    }
}