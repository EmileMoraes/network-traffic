package com.network.traffic.app.controller;

import com.network.traffic.app.service.File;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {

        File myFile = new File();

        myFile.createFile();
        myFile.writeFile();
        int[] myarr = myFile.readFile();
        System.out.println("In main class: " + Arrays.toString(myarr));
    }
}
