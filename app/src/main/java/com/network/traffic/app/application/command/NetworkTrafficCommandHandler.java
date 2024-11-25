package com.network.traffic.app.application.command;

import com.network.traffic.app.application.interfaces.TrafficData;
import com.network.traffic.app.domain.service.NetworkTrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NetworkTrafficCommandHandler {

    @Autowired
    public TrafficData trafficData;

    @Autowired
    private NetworkTrafficService networkTrafficService;

    public void handler() {

        int[] trafficData = this.trafficData.readTrafficData();
        networkTrafficService.handler(trafficData, 1, 2);
    }
}
