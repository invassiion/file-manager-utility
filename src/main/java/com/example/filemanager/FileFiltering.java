package com.example.filemanager;

import com.example.filemanager.config.LogConfig;
import com.example.filemanager.models.Statistics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class FileFiltering {

    private static final Logger logger = LogManager.getLogger(FileFiltering.class);

    public static void main(String[] args) {
        LogConfig.configure();
        ArgumentParser argumentParser = ArgumentParser.parseArgs(args);

        if (argumentParser.getInputFiles() == null || argumentParser.getInputFiles().isEmpty()) {
            logger.error("No input files specified");
            System.out.println("No input files specified");
            return;
        }

        logger.info("Starting file filtering utility...");
        System.out.println("Starting file filtering utility...");

        FileManager fileManager = new FileManager(argumentParser.getOutputDirectory(), argumentParser.getPrefix(), argumentParser.isAppend());
        DataProcessor dataProcessor = new DataProcessor();
        StatisticCollector statisticCollector =  new StatisticCollector();

        try {
            List<String> lines = fileManager.readLines(argumentParser.getInputFiles());

            for (String line : lines) {
                dataProcessor.processLine(line);
            }
            fileManager.writeIntegerData(dataProcessor.getIntegerData());
            fileManager.writeFloatData(dataProcessor.getFloatData());
            fileManager.writeStringData(dataProcessor.getStringData());

            if (argumentParser.isShortStatistics() || argumentParser.isFullStatistics()) {
                if (argumentParser.isShortStatistics()) {
                    printShortStatistics(dataProcessor, statisticCollector);
                } else {
                    printFullStatistics(dataProcessor, statisticCollector);
                }
            }
        }  catch (IOException e) {
            logger.error("Error processing files: ", e);
            System.err.println("Error processing files: " + e.getMessage());
        }
    }

    private static void printShortStatistics(DataProcessor dataProcessor, StatisticCollector statisticsCollector) {
        int integerCount = dataProcessor.getIntegerData().size();
        int floatCount = dataProcessor.getFloatData().size();
        int stringCount = dataProcessor.getStringData().size();

        System.out.println("Short Statistics:");
        System.out.println("Integers: " + integerCount);
        System.out.println("Floats: " + floatCount);
        System.out.println("Strings: " + stringCount);
    }

    private static void printFullStatistics(DataProcessor dataProcessor, StatisticCollector statisticsCollector) {
        Statistics integerStats = statisticsCollector.collectIntegerStatistics(dataProcessor.getIntegerData());
        Statistics floatStats = statisticsCollector.collectFloatStatistics(dataProcessor.getFloatData());
        Statistics stringStats = statisticsCollector.collectStringStatistics(dataProcessor.getStringData());

        System.out.println("Full Statistics:");

        System.out.println("Integers:");
        System.out.println("Count: " + integerStats.getCount());
        System.out.println("Min: " + integerStats.getMin());
        System.out.println("Max: " + integerStats.getMax());
        System.out.println("Sum: " + integerStats.getSum());
        System.out.println("Average: " + integerStats.getAverage());

        System.out.println("Floats:");
        System.out.println("Count: " + floatStats.getCount());
        System.out.println("Min: " + floatStats.getMin());
        System.out.println("Max: " + floatStats.getMax());
        System.out.println("Sum: " + floatStats.getSum());
        System.out.println("Average: " + floatStats.getAverage());

        System.out.println("Strings:");
        System.out.println("Count: " + stringStats.getCount());
        System.out.println("Min Length: " + stringStats.getMinLength());
        System.out.println("Max Length: " + stringStats.getMaxLength());
    }

}
