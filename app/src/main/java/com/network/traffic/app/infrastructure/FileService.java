package com.network.traffic.app.infrastructure;

import com.network.traffic.app.application.interfaces.TrafficData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

@Service
public class FileService implements TrafficData {
    private static final Logger logger = LoggerFactory.getLogger(FileService.class);
    private static final String FILE_NAME = "trafficNetwork.txt";

    @Override
    public int[] readTrafficData() {
        logger.info("Initialize traffic data");

        int[] data = readDataFromFile();
        logger.info("File with values: {}", Arrays.toString(data));
        return data;
    }

    private int[] readDataFromFile() {
        try {
            java.io.File file = new java.io.File(FILE_NAME);
            if (file.createNewFile()) {
                logger.info("File created: {}", file.getAbsolutePath());
            }

            FileWriter myWriter = new FileWriter(FILE_NAME);
            Integer[] arr = {10, 20, 30, 40, 50, 60};
            for (int i = 0; i < arr.length; i++) {
                myWriter.write(arr[i] + " ");
            }
            myWriter.close();

            Scanner myReader = new Scanner(file);
            if (!myReader.hasNextLine()) {
                logger.info("File empty");
                return new int[0];
            }

            String[] dataString = myReader.nextLine().replaceAll(" ", ",").split(",");
            int[] data = new int[dataString.length];

            for (int i = 0; i < dataString.length; i++) {
                data[i] = Integer.parseInt(dataString[i]);
            }
            return data;

        } catch (IOException e) {
            logger.error("An error occurred.", e);
            throw new RuntimeException("Error reading traffic data", e);
        }
    }
}