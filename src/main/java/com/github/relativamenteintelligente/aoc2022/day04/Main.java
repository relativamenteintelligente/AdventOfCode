package com.github.relativamenteintelligente.aoc2022.day04;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String FILE_NAME = "input/04.txt";

    public static Pair<Interval, Interval> parseLine(String line) {
        var intervals = line.split(",");
        if (intervals.length != 2) {
            throw new IllegalArgumentException("Each line must be composed of two intervals.");
        }
        return new ImmutablePair<>(
            Interval.fromString(intervals[0]),
            Interval.fromString(intervals[1]));
    }

    public static List<Pair<Interval, Interval>> parseInput() {
        List<Pair<Interval, Interval>> result = new ArrayList<>();
        try (var reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }
                result.add(parseLine(line));
            }
        } catch (IOException e) {
            System.out.println("Couldn't parse input");
            System.exit(1);
        }
        return result;
    }

    public static Long partOne() {
        return parseInput().stream()
            .filter(pair -> pair.getLeft().fullyOverlapsWith(pair.getRight()))
            .count();
    }
    
    public static Long partTwo() {
        return parseInput().stream()
            .filter(pair -> pair.getLeft().overlapsWith(pair.getRight()))
            .count();
    }

    public static void main(String[] args) {
        System.out.println("Number of fully overlapping intervals: " + partOne());
        System.out.println("Number of partially overlapping intervals: " + partTwo());
    }
}
