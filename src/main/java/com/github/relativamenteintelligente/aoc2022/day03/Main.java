package com.github.relativamenteintelligente.aoc2022.day03;

import org.apache.commons.lang3.ArrayUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    private static final String FILE_NAME = "input/03.txt";

    public static List<Rucksack> parseInput() {
        List<Rucksack> result = new ArrayList<>();
        try (var reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }
                result.add(new Rucksack(
                    Arrays.asList(
                        ArrayUtils.toObject(
                            line.getBytes()))));
            }
            return result;
        } catch (IOException e) {
            return result;
        }
    }

    public static Integer itemPriority(Byte item) {
        if ('a' <= item && item <= 'z') {
            return item - 'a' + 1;
        }
        if ('A' <= item && item <= 'Z') {
            return item - 'A' + 27;
        }
        return 0;
    }

    public static Integer partOne() {
        return parseInput().stream()
            .map(Rucksack::getCommonItems)
            .map(commons -> commons.get(0))
            .map(Main::itemPriority)
            .reduce(0, Integer::sum);
    }

    public static Integer partTwo() {
        Integer result = 0;
        var iterator = parseInput().listIterator();
        while (iterator.hasNext()) {
            var rucksack1 = iterator.next();
            var rucksack2 = iterator.next();
            var rucksack3 = iterator.next();
            var commonItem = rucksack1.getItems().stream()
                .filter(rucksack2.getItems()::contains)
                .filter(rucksack3.getItems()::contains)
                .toList().get(0);
            result += itemPriority(commonItem);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("The sum of the priorities is " + partOne());
        System.out.println("The sum of the priorities of badges is " + partTwo());
    }
}
