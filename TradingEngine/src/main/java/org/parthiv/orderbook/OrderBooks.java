package org.parthiv.orderbook;

import org.parthiv.security.ISecurity;
import org.parthiv.servers.IOrderRequest;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class OrderBooks {
    private final ConcurrentMap<ISecurity, IOrderBook> orderBooks;
    private final BlockingQueue<IOrderRequest> requests;
    public OrderBooks(List<ISecurity> securities) {
        orderBooks = new ConcurrentHashMap<>();
        securities.forEach(
                security -> orderBooks.put(security, new OrderBook(security.toString()))
        );
    }
    public IOrderBook getOrderBook(ISecurity security) {
        return orderBooks.get(security);
    }
    public void listSecurity(ISecurity security) {
        orderBooks.put(security, new OrderBook(security));
    }
}
