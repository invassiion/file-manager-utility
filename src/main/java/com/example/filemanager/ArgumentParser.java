package com.example.filemanager;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

public class ArgumentParser {

    @Parameter(names = {"-o"}, description = "Output directory")
    private String outputDirectory = ".";

    @Parameter(names = {"-p"}, description = "Prefix for output files")
    private String prefix = "";

    @Parameter(names = {"-a"}, description = "Append to existing files")
    private boolean append = false;

    @Parameter(names = {"-s"}, description = "Short statistics")
    private boolean shortStatistics = false;

    @Parameter(names = {"-f"}, description = "Full statistics")
    private boolean fullStatistics = false;

    @Parameter(description = "Input files")
    private List<String> inputFiles = new ArrayList<>();

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
