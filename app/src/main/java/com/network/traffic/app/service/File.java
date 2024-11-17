package com.network.traffic.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class File {
    private static final Logger logger = LoggerFactory.getLogger(File.class);

    public void createFile() {
        try {
            java.io.File myFile = new java.io.File("trafficNetwork.txt");
            if (myFile.createNewFile()) {
                logger.info("File created: {}", myFile.getAbsolutePath());
            } else {
                logger.error("File already exists");
            }
        } catch (IOException e) {
            logger.error("An error occurred.", e.getCause());
        }
    }

    public void writeFile() {
        try {
            FileWriter myWriter = new FileWriter("trafficNetwork.txt");
            Integer[] arr = {10, 20, 30, 40, 50, 60};
            for (int i = 0; i < arr.length; i++) {
                myWriter.write(arr[i] + " ");
            }
            myWriter.close();
            logger.info("Successfully wrote to the file");

        } catch (IOException e) {
            logger.error("An error occurred.", e.getCause());
        }

    }

    public int[] readFile() {
        try {
            java.io.File file = new java.io.File("trafficNetwork.txt");
            Scanner myReader = new Scanner(file);

            String[] refactor = myReader.nextLine().replaceAll(" ", ",").split(",");
            int[] array = new int[refactor.length];

            for (int i = 0; i < refactor.length; i++) {
                array[i] = Integer.parseInt(refactor[i]);
            }

            logger.info("File with values: {}", Arrays.toString(array));
            return array;

        } catch (IOException e) {
            logger.error("An error occurred.", e.getCause());
        }
        return null;
    }
}
