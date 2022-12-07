package com.github.relativamenteintelligente.aoc2022.day07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String FILE_NAME = "input/07.txt";

    private static ElfSystem parseInput() throws Exception {
        var elfSystem = new ElfSystem();
        try (var reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            List<String> commandAndOutput = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                if (line.startsWith("$ ") && !commandAndOutput.isEmpty()) {
                    elfSystem.syncronize(commandAndOutput);
                    commandAndOutput = new ArrayList<>();
                }
                commandAndOutput.add(line);
            }
        }
        return elfSystem;
    }

    public static void main(String[] args) throws Exception {
        var elfSystem = parseInput();

        // First star
        var sumOfSizes = elfSystem.getAllDirectories().parallelStream()
            .map(Directory::getSize)
            .filter(directorySize -> directorySize <= 100000.0)
            .reduce(0, Integer::sum);
        System.out.println("Sum of sizes of directories of size < 100000: " + sumOfSizes);

        // Second star
        var usedSpace = elfSystem.getRoot().getSize();
        var totalDiskSpace = 70000000;
        var wantedFreeSpace = 30000000;
        var spaceToFree = usedSpace - (totalDiskSpace - wantedFreeSpace);
        if (spaceToFree < 0) {
            throw new Exception("Hello baka");
        }

        var sizeOfSmallestDirectoryToDelete = elfSystem.getAllDirectories().parallelStream()
            .map(Directory::getSize)
            .filter(directorySize -> directorySize >= spaceToFree)
            .min(Integer::compare)
            .orElse(null);
        System.out.println("Smallest directory to delete has size: " + sizeOfSmallestDirectoryToDelete);
    }
}
