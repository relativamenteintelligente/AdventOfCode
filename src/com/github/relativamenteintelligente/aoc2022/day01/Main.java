package com.github.relativamenteintelligente.aoc2022.day01;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class Main {
    private static BufferedReader reader;
    private static Logger logger;

    static {
        logger = Logger.getGlobal();
        try {
            reader = new BufferedReader(new FileReader("src/p01/input01.txt"));
        } catch (Exception e) {
            System.exit(1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        Integer partialResult = 0;
        Integer maxResult = 0;
        List<Integer> allResults = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            try {
                partialResult += Integer.parseInt(line);
            } catch (NumberFormatException e) {
                maxResult = Math.max(maxResult, partialResult);
                allResults.add(partialResult);
                partialResult = 0;
            }
        }
        // Star 1
        logger.log(Level.INFO,
            "Maximum amount of calories carried by an elf: {0}",
            maxResult);

        // Star 2
        allResults.sort((Integer n1, Integer n2) -> n2 - n1);
        var first = allResults.get(0);
        var second = allResults.get(1);
        var third = allResults.get(2);

        logger.log(Level.INFO,
            "Sum of calories carried by the top three elves: {0}",
            (first + second + third));
    }
}
