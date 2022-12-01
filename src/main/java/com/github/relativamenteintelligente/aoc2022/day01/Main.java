package com.github.relativamenteintelligente.aoc2022.day01;

import java.io.*;
import java.text.MessageFormat;
import java.util.*;

public class Main {
    private static final String INPUT_FILE_NAME = "input/01.txt";

    public static List<Integer> readAndSortCaloriesPerElf() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_NAME))) {
            List<Integer> allResults = new ArrayList<>();
            Integer partialResult = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    partialResult += Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    allResults.add(partialResult);
                    partialResult = 0;
                }
            }
            allResults.sort((Integer n1, Integer n2) -> n2 - n1);
            return allResults;
        }
    }

    public static Integer getMaxCalories(List<Integer> listCalories) {
        return listCalories.get(0);
    }

    public static Integer getSumTopThreeCalories(List<Integer> listCalories) {
        return listCalories.get(0) + listCalories.get(1) + listCalories.get(2);
    }

    public static void main(String[] args) throws IOException {
        var listCalories = readAndSortCaloriesPerElf();

        // Star 1
        System.out.println(MessageFormat.format(
            "Maximum amount of calories carried by an elf: {0}",
            getMaxCalories(listCalories)));

        // Star 2
        System.out.println(MessageFormat.format(
            "Sum of calories carried by the top three elves: {0}",
            getSumTopThreeCalories(listCalories)));
    }
}
