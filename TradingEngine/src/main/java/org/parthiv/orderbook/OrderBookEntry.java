package org.parthiv.orderbook;

import org.parthiv.orderbook.orders.OrderCore;

import java.time.Instant;
import java.util.Date;

public class OrderBookEntry{
    final OrderCore orderCore;
    final int quantity;
    final Date creationTime;
    final Long price;

    public OrderBookEntry(OrderCore orderCore, int quantity, long price) {
        this.orderCore = orderCore;
        this.quantity = quantity;
        this.price = price;
        this.creationTime = Date.from(Instant.now());
    }

    public String getOrderId(){
        return orderCore.getOrderId();
    }

    public String getUsername(){
        return orderCore.getUsername();
    }
}
