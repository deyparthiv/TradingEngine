package org.parthiv.orderbook;

import org.parthiv.orderbook.orders.LimitOrder;
import org.parthiv.orderbook.orders.MarketOrder;

public class OrderAdder implements IOrderVisitor, IOrderBookWriter {
    /**
     * @param order
     */
    final OrderBook orderBook;

    public OrderAdder(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    /**
     * Add the given limit order to the order book
     *
     * @param order the limit order
     */
    @Override
    public void visit(LimitOrder order) {
        if (orderBook.orderBookEntries.containsKey(order.getOrderId()))
            throw new IllegalArgumentException("tried to add order which already exists");

        long price = order.getPrice();
        boolean isBuySide = order.isBuySide();
        OrderBookEntry obe = new OrderBookEntry(
                order.getUsername(), order.getQuantity(), order.getPrice()
        );
        if (isBuySide) { //order is a bid
            if (orderBook.bids.containsKey(price)) {
                orderBook.bids.get(price)
                        .ordersAtPriceLevel.add(obe);
            } else {
                PriceLevel level = new PriceLevel(price);
                level.ordersAtPriceLevel.add(obe);
                orderBook.bids.put(price, level);
            }
        } else { //order is an ask
            if (orderBook.asks.containsKey(price)) {
                orderBook.asks.get(price)
                        .ordersAtPriceLevel.add(obe);
            } else {
                PriceLevel level = new PriceLevel(price);
                level.ordersAtPriceLevel.add(obe);
                orderBook.asks.put(price, level);
            }
        }
        orderBook.orderBookEntries.put(order.getOrderId(), obe);
    }

    /**
     * @param order
     */
    @Override
    public void visit(MarketOrder order) {

    }
}
