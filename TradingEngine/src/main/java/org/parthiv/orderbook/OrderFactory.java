package org.parthiv.orderbook;

import org.parthiv.orderbook.orders.IOrder;
import org.parthiv.orderbook.orders.LimitOrder;
import org.parthiv.orderbook.orders.MarketOrder;

/**
 * interface to build orders from communications
 */

// limit order: limit add userid securityid price quantity
//              limit remove userid securityid price quantity
//market order:
public final class OrderFactory {
    public static IOrder parseOrderMessage(String message){
        String[] tokens = message.split(",");
        switch(tokens[0]){
            case "L":
                return buildLimitOrder(message);
            case "M":
                return new MarketOrder(tokens[1], tokens[2]);
            default:
                return null;
        }
    }
    private static LimitOrder buildLimitOrder(String message){
        String[] tokens = message.split(",");
    }
}
