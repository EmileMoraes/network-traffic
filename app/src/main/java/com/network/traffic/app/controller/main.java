package com.network.traffic.app.controller;

import com.network.traffic.app.service.File;
import com.network.traffic.app.service.NetworkTrafficService;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {

        File myFile = new File();

        myFile.createFile();
        myFile.writeFile();

        NetworkTrafficService networkTrafficService = new NetworkTrafficService(myFile);
        networkTrafficService.handler(1, 3);
    }
}
