package com.github.relativamenteintelligente.aoc2022.day06;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String FILE_NAME = "input/06.txt";

    public static Integer startedMarker(Integer numberOfDistinctChars) {
        var circularList = new CircularArray(numberOfDistinctChars);
        try (var reader = new BufferedReader(new FileReader(FILE_NAME))) {
            while (!circularList.distinct()) {
                var element = reader.read();
                if (element == -1) {
                    throw new IOException("Empty stream error.");
                }
                circularList.add(element);
            }
        } catch (IOException e) {
            System.out.println("Couldn't parse input");
            System.exit(1);
        }
        return circularList.getCounter();
    }

    public static void main(String[] args) {
        System.out.println("First start-of-packet marker after index: " + startedMarker(4));
        System.out.println("First start-of-message marker after index: " + startedMarker(14));
    }
}
