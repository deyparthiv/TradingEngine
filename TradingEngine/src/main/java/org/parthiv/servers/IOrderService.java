package org.parthiv.servers;


public interface IOrderService extends ITradingEngineService {
    void receiveOrder(String order);
    void broadcastToClients();
}
