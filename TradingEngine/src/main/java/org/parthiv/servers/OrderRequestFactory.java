package org.parthiv.servers;

import org.parthiv.orderbook.IOrderVisitor;
import org.parthiv.orderbook.OrderAdder;
import org.parthiv.orderbook.OrderFactory;
import org.parthiv.orderbook.orders.IOrder;

public final class OrderRequestFactory {
    public static IOrderRequest createOrderRequest(String message) {
        return new IOrderRequest() {
            @Override
            public IOrder getOrder() {
                OrderFactory.parseOrderMessage(message);
            }

            @Override
            public IOrderVisitor getAction() {
                String[] tokens = message.split(" ");
                if(tokens[2].equals("add")) return new OrderAdder();
            }
        }
    }
}
