package org.parthiv.orderbook.orders;

public interface ILimitOrder extends IOrder{
    public long getPrice();
    public boolean isBuySide();
}
