package com.github.relativamenteintelligente.aoc2022.day10;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    private static final String FILE_NAME = "input/10.txt";

    public static List<Pair<Instruction, Object[]>> parseInput(BufferedReader reader) throws IOException {
        List<Pair<Instruction, Object[]>> result = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isBlank()) {
                continue;
            }
            var tokens = line.split(" ");
            result.add(
                switch (tokens[0]) {
                    case "noop" -> new ImmutablePair<>(Instruction.NOOP, null);
                    case "addx" -> new ImmutablePair<>(Instruction.ADDX,
                        new Object[]{Integer.parseInt(tokens[1])});
                    default -> throw new IllegalArgumentException();
                });
        }
        return result;
    }

    public static Integer cumulativeSignalStrength(BufferedReader reader) throws Exception {
        AtomicReference<Integer> cumulativeSignalStrength = new AtomicReference<>(0);
        List<Integer> cyclesOfInterest = Arrays.asList(20, 60, 100, 140, 180, 220);

        var cpu = new Cpu(c ->
        {
            if (cyclesOfInterest.contains(c.getCycleCount())) {
                System.out.println(c);
                cumulativeSignalStrength.updateAndGet(v -> v + c.signalStrength());
            }
        });

        parseInput(reader).forEach(pair -> cpu.cycle(pair.getLeft(), pair.getRight()));

        return cumulativeSignalStrength.get();
    }

    public static void crtPrint(BufferedReader reader) throws Exception {
        var cpu = new Cpu(c ->
        {
            var cycleCount = c.getCycleCount();

            var middleSprite = c.getRegisterX();
            var horizontalPosition = (cycleCount - 1) % 40;
            System.out.print(Math.abs(horizontalPosition - middleSprite) < 2 ? "#" : ".");

            if (cycleCount % 40 == 0) {
                System.out.println();
            }
        });

        parseInput(reader).forEach(pair -> cpu.cycle(pair.getLeft(), pair.getRight()));
    }

    public static void main(String[] args) throws Exception {
        // First star
        try (var reader = new BufferedReader(new FileReader(FILE_NAME))) {
            Integer cumulativeSignalStrength = cumulativeSignalStrength(reader);
            System.out.println("Cumultative signal strength: " + cumulativeSignalStrength);
        }

        // Second star
        try (var reader = new BufferedReader(new FileReader(FILE_NAME))) {
            crtPrint(reader);
        }
    }
}
