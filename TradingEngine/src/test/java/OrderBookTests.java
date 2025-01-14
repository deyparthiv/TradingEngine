import org.junit.jupiter.api.Test;
import org.parthiv.orderbook.OrderAdder;
import org.parthiv.orderbook.OrderBook;
import org.parthiv.orderbook.OrderRemover;
import org.parthiv.orderbook.orders.LimitOrder;
import org.parthiv.orderbook.orders.OrderCore;
import org.parthiv.security.ISecurity;
import org.parthiv.security.Security;

public class OrderBookTests {
    @Test
    public void testAddBuyLimitOrder() {
        String mockSecurityId = "1";
        ISecurity mockSecurity = new Security(mockSecurityId,"random");
        OrderBook orderBook = new OrderBook(mockSecurity);
        OrderAdder adder = new OrderAdder(orderBook);

        String mockOrderId = "orderId";
        String mockUsername = "username";
        OrderCore orderCore = new OrderCore(mockOrderId, mockUsername, mockSecurityId);

        int quantity = 10;
        long price = 5;
        boolean isBuySide = true;
        LimitOrder limitOrder = new LimitOrder(orderCore, quantity, price, isBuySide);
        adder.visit(limitOrder);
        assert (orderBook.containsOrder(limitOrder.getOrderId()));
    }

    @Test
    public void testRemoveBuyLimitOrder() {
        //add order
        String mockSecurityId = "1";
        ISecurity mockSecurity = new Security(mockSecurityId,"random");

        OrderBook orderBook = new OrderBook(mockSecurity);
        OrderAdder adder = new OrderAdder(orderBook);

        String mockOrderId = "orderId";
        String mockUsername = "username";
        OrderCore orderCore = new OrderCore(mockOrderId, mockUsername, mockSecurityId);

        int quantity = 10;
        long price = 5;
        boolean isBuySide = true;
        LimitOrder limitOrder = new LimitOrder(orderCore, quantity, price, isBuySide);
        adder.visit(limitOrder);

        //remove order
        OrderRemover remover = new OrderRemover(orderBook);
        remover.visit(limitOrder);
        assert (!orderBook.containsOrder(limitOrder.getOrderId()));
    }

    @Test
    public void testAddSellLimitOrder() {
        String mockSecurityId = "1";
        ISecurity mockSecurity = new Security(mockSecurityId,"random");
        OrderBook orderBook = new OrderBook(mockSecurity);
        OrderAdder adder = new OrderAdder(orderBook);

        String mockOrderId = "orderId";
        String mockUsername = "username";
        OrderCore orderCore = new OrderCore(mockOrderId, mockUsername, mockSecurityId);

        int quantity = 10;
        long price = 5;
        boolean isBuySide = false;
        LimitOrder limitOrder = new LimitOrder(orderCore, quantity, price, isBuySide);
        adder.visit(limitOrder);
        assert (orderBook.containsOrder(limitOrder.getOrderId()));
    }

    @Test
    public void testRemoveSellLimitOrder() {
        //add order
        String mockSecurityId = "1";
        ISecurity mockSecurity = new Security(mockSecurityId,"random");
        OrderBook orderBook = new OrderBook(mockSecurity);
        OrderAdder adder = new OrderAdder(orderBook);

        String mockOrderId = "orderId";
        String mockUsername = "username";
        OrderCore orderCore = new OrderCore(mockOrderId, mockUsername, mockSecurityId);

        int quantity = 10;
        long price = 5;
        boolean isBuySide = false;
        LimitOrder limitOrder = new LimitOrder(orderCore, quantity, price, isBuySide);
        adder.visit(limitOrder);

        //remove order
        OrderRemover remover = new OrderRemover(orderBook);
        remover.visit(limitOrder);
        assert (!orderBook.containsOrder(limitOrder.getOrderId()));
    }

    @Test
    public void testBidsOrderingByPrice() {
        String mockSecurityId = "security";
        ISecurity mockSecurity = new Security(mockSecurityId,"random");
        OrderBook orderBook = new OrderBook(mockSecurity);

        OrderAdder orderAdder = new OrderAdder(orderBook);

        //create order1 with price 5
        String mockOrderId = "order1";
        String mockUsername = "user1";
        OrderCore orderCore1 = new OrderCore(mockOrderId, mockUsername, mockSecurityId);
        LimitOrder order1 = new LimitOrder(orderCore1, 10, 5, true);
        orderAdder.visit(order1);
        //create order2 with price 6
        String mockOrderId2 = "order2";
        String mockUsername2 = "user2";
        OrderCore orderCore2 = new OrderCore(mockOrderId2, mockUsername2, mockSecurityId);
        LimitOrder order2 = new LimitOrder(orderCore2, 10, 6, true);
        orderAdder.visit(order2);

        assert (orderBook.bids.firstKey() == 6);
    }

    @Test
    public void testAsksOrderingByPrice() {
        String mockSecurityId = "security";
        ISecurity mockSecurity = new Security(mockSecurityId,"random");
        OrderBook orderBook = new OrderBook(mockSecurity);

        OrderAdder orderAdder = new OrderAdder(orderBook);

        //create order1 with price 5
        String mockOrderId = "order1";
        String mockUsername = "user1";
        OrderCore orderCore1 = new OrderCore(mockOrderId, mockUsername, mockSecurityId);
        LimitOrder order1 = new LimitOrder(orderCore1, 10, 5, false);
        orderAdder.visit(order1);
        //create order2 with price 6
        String mockOrderId2 = "order2";
        String mockUsername2 = "user2";
        OrderCore orderCore2 = new OrderCore(mockOrderId2, mockUsername2, mockSecurityId);
        LimitOrder order2 = new LimitOrder(orderCore2, 10, 6, false);
        orderAdder.visit(order2);

        assert (orderBook.asks.firstKey() == 5);
    }

    @Test
    public void testBidsOrderingAtSamePrice() {
        String mockSecurityId = "security";
        ISecurity mockSecurity = new Security(mockSecurityId,"random");
        OrderBook orderBook = new OrderBook(mockSecurity);
        long price = 5;

        String orderId1 = "order1";
        LimitOrder order1 = new LimitOrder(
                new OrderCore(orderId1, "trader1", mockSecurityId),
                10,
                price,
                true
        );
        String orderId2 = "order2";
        LimitOrder order2 = new LimitOrder(
                new OrderCore(orderId2, "trader1", mockSecurityId),
                10,
                price,
                true
        );

        OrderAdder adder = new OrderAdder(orderBook);
        adder.visit(order1);
        adder.visit(order2);
        assert(orderBook.bids.get(price).ordersAtPriceLevel.peek().getOrderId().equals(orderId1));
    }

    @Test
    public void testAsksOrderingAtSamePrice() {
        String mockSecurityId = "security";
        ISecurity mockSecurity = new Security(mockSecurityId,"random");
        OrderBook orderBook = new OrderBook(mockSecurity);
        long price = 5;

        String orderId1 = "order1";
        LimitOrder order1 = new LimitOrder(
                new OrderCore(orderId1, "trader1", mockSecurityId),
                10,
                price,
                false
        );
        String orderId2 = "order2";
        LimitOrder order2 = new LimitOrder(
                new OrderCore(orderId2, "trader1", mockSecurityId),
                10,
                price,
                false
        );

        OrderAdder adder = new OrderAdder(orderBook);
        adder.visit(order1);
        adder.visit(order2);
        assert(orderBook.asks.get(price).ordersAtPriceLevel.peek().getOrderId().equals(orderId1));
    }
}
