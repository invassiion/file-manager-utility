package com.example.filemanager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final Logger logger = LogManager.getLogger(FileManager.class);

    private final String outputDirectory;
    private final String prefix;
    private final boolean append;

    public FileManager(String outputDirectory, String prefix, boolean append) {
        this.outputDirectory = outputDirectory;
        this.prefix = prefix;
        this.append = append;
    }

    public List<String> readLines(List<String> inputFiles) throws IOException {
        List<String> lines = new ArrayList<>();

        for (String fileName : inputFiles) {
            Path path = Paths.get(fileName);
            if (Files.exists(path)) {
                lines.addAll(Files.readAllLines(path));
                logger.info("Read lines from file: " + fileName);
            } else {
                logger.warn("File does not exist: " + fileName);
            }
        }
        return lines;
    }

    private void writeLines(List<String> data, String fileName) throws IOException{
        if (data.isEmpty()) {
            return;
        }

        Path path = Paths.get(outputDirectory, prefix + fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), append))) {
          for (String line : data) {
              writer.write(line);
              writer.newLine();
          }
          logger.info("Wrote data to file: " + path);
        }
    }

    public void writeIntegerData( List<String> integerData) throws IOException {
        writeLines(integerData, "integers.txt");
    }

    public void writeFloatData(List<String> floatData) throws IOException {
        writeLines(floatData, "floats.txt");
    }

    public void writeStringData(List<String> stringData) throws IOException {
        writeLines(stringData, "strings.txt");
    }
}
