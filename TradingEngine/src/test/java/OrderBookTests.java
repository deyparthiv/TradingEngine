import org.junit.jupiter.api.Test;
import org.parthiv.orderbook.OrderAdder;
import org.parthiv.orderbook.OrderBook;
import org.parthiv.orderbook.OrderRemover;
import org.parthiv.orderbook.orders.LimitOrder;
import org.parthiv.orderbook.orders.OrderCore;

public class OrderBookTests {
    @Test
    public void testAddBuyLimitOrder(){
        String mockSecurityId = "1";
        OrderBook orderBook = new OrderBook(mockSecurityId);
        OrderAdder adder = new OrderAdder(orderBook);

        String mockOrderId = "orderId";
        String mockUsername = "username";
        OrderCore orderCore = new OrderCore(mockOrderId,mockUsername,mockSecurityId);

        int quantity = 10;
        long price = 5;
        boolean isBuySide = true;
        LimitOrder limitOrder = new LimitOrder(orderCore,quantity,price,isBuySide);
        adder.visit(limitOrder);
        assert(orderBook.containsOrder(limitOrder.getOrderId()));
    }
    @Test
    public void testRemoveBuyLimitOrder(){
        //add order
        String mockSecurityId = "1";
        OrderBook orderBook = new OrderBook(mockSecurityId);
        OrderAdder adder = new OrderAdder(orderBook);

        String mockOrderId = "orderId";
        String mockUsername = "username";
        OrderCore orderCore = new OrderCore(mockOrderId,mockUsername,mockSecurityId);

        int quantity = 10;
        long price = 5;
        boolean isBuySide = true;
        LimitOrder limitOrder = new LimitOrder(orderCore,quantity,price,isBuySide);
        adder.visit(limitOrder);

        //remove order
        OrderRemover remover = new OrderRemover(orderBook);
        remover.visit(limitOrder);
        assert(!orderBook.containsOrder(limitOrder.getOrderId()));
    }

    @Test
    public void testAddSellLimitOrder(){
        String mockSecurityId = "1";
        OrderBook orderBook = new OrderBook(mockSecurityId);
        OrderAdder adder = new OrderAdder(orderBook);

        String mockOrderId = "orderId";
        String mockUsername = "username";
        OrderCore orderCore = new OrderCore(mockOrderId,mockUsername,mockSecurityId);

        int quantity = 10;
        long price = 5;
        boolean isBuySide = false;
        LimitOrder limitOrder = new LimitOrder(orderCore,quantity,price,isBuySide);
        adder.visit(limitOrder);
        assert(orderBook.containsOrder(limitOrder.getOrderId()));
    }
    @Test
    public void testRemoveSellLimitOrder(){
        //add order
        String mockSecurityId = "1";
        OrderBook orderBook = new OrderBook(mockSecurityId);
        OrderAdder adder = new OrderAdder(orderBook);

        String mockOrderId = "orderId";
        String mockUsername = "username";
        OrderCore orderCore = new OrderCore(mockOrderId,mockUsername,mockSecurityId);

        int quantity = 10;
        long price = 5;
        boolean isBuySide = false;
        LimitOrder limitOrder = new LimitOrder(orderCore,quantity,price,isBuySide);
        adder.visit(limitOrder);

        //remove order
        OrderRemover remover = new OrderRemover(orderBook);
        remover.visit(limitOrder);
        assert(!orderBook.containsOrder(limitOrder.getOrderId()));
    }

}
