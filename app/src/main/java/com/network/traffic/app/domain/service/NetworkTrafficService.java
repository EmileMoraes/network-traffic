package com.network.traffic.app.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class NetworkTrafficService {
    private static final Logger logger = LoggerFactory.getLogger(NetworkTrafficService.class);
    private int[] values;

    public void handler(int[] arr, int first, int end){
        if(values == null){
            values = prefixSum(arr);
        }

        int result = values[end + 1] - values[first]; 
        logger.info("The range is: {}", result);
    }

    private int[] prefixSum(int[] arr){
        int[] myArr = new int[arr.length + 1];

        logger.info("Initialize prefix sum calculation");

        for(int i = 1; i < myArr.length; i++){
            myArr[i] = myArr[i - 1] + arr[i - 1];
        }

        logger.info("Prefix sum successfully proceed: {}", Arrays.toString(myArr));

        return myArr;
    }
}
