package com.github.relativamenteintelligente.aoc2022.day09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public class Main {
    private static final String FILE_NAME = "input/09.txt";

    public static void parseInput(BufferedReader reader, Consumer<Direction> coDirection) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isBlank()) {
                continue;
            }
            var tokens = line.split(" ");
            var direction = Direction.fromString(tokens[0]);
            var num = Integer.parseInt(tokens[1]);
            for (int i = 0; i < num; i++) {
                coDirection.accept(direction);
            }
        }
    }

    public static void main(String[] args) {
        Rope rope = new Rope();
        try (var reader = new BufferedReader(new FileReader(FILE_NAME))) {
            parseInput(reader, rope::move);
        } catch (Exception e) {
            System.out.println("Error parsing input: " + e.getMessage());
            System.exit(1);
        }
        System.out.println("Number of unique tail positions: " + rope.numberOfUniqueTailPositions());
    }
}
