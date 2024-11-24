package com.network.traffic.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class NetworkTrafficService {
    private static final Logger logger = LoggerFactory.getLogger(NetworkTrafficService.class);
    private File file;
    private int[] values;

    public NetworkTrafficService(File file){
        this.file = file;
    }

    public int handler(int first, int end){
        if(values == null){
            values = prefixSum();
        }
        int result = values[end + 1] - values[first];
        logger.info("The range is: {}", result);
        return result;
    }

    public int[] prefixSum(){
        int[] prefixSum = file.readFile();
        int[] myArr = new int[prefixSum.length + 1];

        logger.info("Initialize prefix sum calculation");

        for(int i = 1; i < myArr.length; i++){
            myArr[i] = myArr[i - 1] + prefixSum[i - 1];
        }

        logger.info("Prefix sum successfully proceed: {}", Arrays.toString(myArr));

        return myArr;
    }
}
