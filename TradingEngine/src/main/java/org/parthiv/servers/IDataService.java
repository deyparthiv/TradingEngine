package org.parthiv.servers;

/**
 * specify an interface for the server clients are getting data from
 */
public interface IDataService extends ITradingEngineService {
    void getPastOrders();
}
