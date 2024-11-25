package com.network.traffic.app.application.interfaces;

import org.springframework.stereotype.Component;

@Component
public interface TrafficData {
    int[] readTrafficData();
}
