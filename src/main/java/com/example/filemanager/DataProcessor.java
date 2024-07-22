package com.example.filemanager;

import com.example.filemanager.models.DataType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    private static final Logger logger = LogManager.getLogger(DataProcessor.class);

    private final List<String> integerData = new ArrayList<>();
    private final List<String> floatData = new ArrayList<>();
    private final List<String> stringData = new ArrayList<>();


    public void processLine(String line) {
        if (line.matches("^-?\\d+$")) {
            integerData.add(line);
            logger.debug("Integer detected: " + line);
        } else if (line.matches("^-?\\d*\\.\\d+$") || line.matches("^-?\\d+\\.\\d*$")) {
            floatData.add(line);
            logger.debug("Float detected: " + line);
        } else {
            stringData.add(line);
            logger.debug("String detected: " + line);
        }
    }
    public List<String> getIntegerData() {
        return integerData;
    }

    public List<String> getFloatData() {
        return floatData;
    }

    public List<String> getStringData() {
        return stringData;
    }

    public DataType determineDataType(String line) {
        if (line.matches("^-?\\d+$")) {
            return DataType.INTEGER;
        } else if (line.matches("^-?\\d*\\.\\d+$") || line.matches("^-?\\d+\\.\\d*$")) {
            return DataType.FLOAT;
        } else {
            return DataType.STRING;
        }
    }
}
