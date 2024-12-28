package org.parthiv.orderbook;

import org.parthiv.orderbook.orders.LimitOrder;
import org.parthiv.orderbook.orders.MarketOrder;

public class OrderRemover implements IOrderVisitor {
    final OrderBook orderBook;
    public OrderRemover(OrderBook orderBook){
        this.orderBook = orderBook;
    }
    /**
     * Remove the given limit order from the order book
     * @param order
     */
    @Override
    public void visit(LimitOrder order) {
        if(!orderBook.orderBookEntries.containsKey(order.getOrderId()))
            throw new IllegalArgumentException("tried to delete order which does not exist");

        OrderBookEntry obe = orderBook.orderBookEntries.get(order.getOrderId());
        if(order.isBuySide()){
            orderBook.asks.get(obe.price).ordersAtPriceLevel.remove(obe);
        }else {
            orderBook.bids.get(obe.price).ordersAtPriceLevel.remove(obe);
        }
        orderBook.orderBookEntries.remove(order.getOrderId());
    }

    /**
     * @param order
     */
    @Override
    public void visit(MarketOrder order) {

    }
}
