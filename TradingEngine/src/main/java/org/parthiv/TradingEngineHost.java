package org.parthiv;

import org.parthiv.servers.DataService;
import org.parthiv.servers.ITradingEngineService;
import org.parthiv.servers.OrderService;

import java.util.ArrayList;
import java.util.List;

public class TradingEngineHost {
    List<ITradingEngineService> services;
    public TradingEngineHost(){
        services = new ArrayList<>();
        DataService dataServer = new DataService();
        OrderService orderService = new OrderService();
    }
    public void start(){
        services.forEach(Runnable::run);
    }


}
