package com.example.filemanager;

import com.beust.jcommander.JCommander;

import java.util.List;

public class ArgumentParser {

    private String outputDirectory = ".";

    private String prefix = "";

    private boolean append = false;

    private boolean shortStatistics = false;

    private boolean fullStatistics = false;

    private List<String> inputFiles;

    public String getOutputDirectory() {
        return outputDirectory;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isAppend() {
        return append;
    }

    public boolean isShortStatistics() {
        return shortStatistics;
    }

    public boolean isFullStatistics() {
        return fullStatistics;
    }

    public List<String> getInputFiles() {
        return inputFiles;
    }

    public static ArgumentParser parseArgs(String[] args) {
        ArgumentParser argumentParser = new ArgumentParser();
        JCommander.newBuilder()
                .addObject(argumentParser)
                .build()
                .parse(args);

        return argumentParser;
    }
}
