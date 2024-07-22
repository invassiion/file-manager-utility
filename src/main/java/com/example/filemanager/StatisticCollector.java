package com.example.filemanager;

import com.example.filemanager.models.Statistics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class StatisticCollector {
    private static final Logger logger = LogManager.getLogger(StatisticCollector.class);

    public Statistics collectIntegerStatistics(List<String> integerData) {
        Statistics statistics = new Statistics();
        statistics.setCount(integerData.size());

        if (!integerData.isEmpty()) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            long sum = 0;

            for (String data : integerData) {
                int value = Integer.parseInt(data);
                if (value < min) {
                    min = value;
                }
                if (value > max) {
                    max = value;
                }
                sum += value;
            }

            statistics.setMin(min);
            statistics.setMax(max);
            statistics.setSum(sum);
            statistics.setAverage((double) sum / integerData.size());
        }
        logger.info("Collected integer statistic: " + statistics);
        return statistics;
    }


    public Statistics collectFloatStatistics(List<String> floatData) {
        Statistics statistics = new Statistics();
        statistics.setCount(floatData.size());

        if (!floatData.isEmpty()) {
            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;
            double sum = 0;

            for (String data : floatData) {
                double value = Double.parseDouble(data);
                if (value < min) {
                    min = value;
                }
                if (value > max) {
                    max = value;
                }
                sum += value;
            }

            statistics.setMin(min);
            statistics.setMax(max);
            statistics.setSum(sum);
            statistics.setAverage(sum / floatData.size());
        }

        logger.info("Collected float statistics: " + statistics);
        return statistics;
    }

    public Statistics collectStringStatistics(List<String> stringData) {
        Statistics statistics = new Statistics();
        statistics.setCount(stringData.size());

        if (!stringData.isEmpty()) {
            int minLength = Integer.MAX_VALUE;
            int maxLength = Integer.MIN_VALUE;

            for (String data : stringData) {
                int length = data.length();
                if (length < minLength) {
                    minLength = length;
                }
                if (length > maxLength) {
                    maxLength = length;
                }
            }

            statistics.setMinLength(minLength);
            statistics.setMaxLength(maxLength);
        }

        logger.info("Collected string statistics: " + statistics);
        return statistics;
    }
}
