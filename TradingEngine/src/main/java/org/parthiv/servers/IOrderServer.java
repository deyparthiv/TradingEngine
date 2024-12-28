package org.parthiv.servers;


public interface IOrderServer{
    void receiveOrder(String order);
    void broadcastToClients();
}
