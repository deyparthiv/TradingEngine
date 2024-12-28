package org.parthiv.orderbook;

import java.time.Instant;
import java.util.Date;

public class OrderBookEntry{
    final String username;
    final int quantity;
    final Date creationTime;
    final Long price;

    public OrderBookEntry(String username, int quantity, long price) {
        this.username = username;
        this.quantity = quantity;
        this.price = price;
        this.creationTime = Date.from(Instant.now());
    }
}
