package com.github.relativamenteintelligente.aoc2022.day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "input/02.txt";

    public static List<SimpleEntry<Hand, Hand>> parseInput() {
        List<SimpleEntry<Hand, Hand>> games = new LinkedList<>();
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // A line has the form "A X"
                var tokens = line.split(" ");
                if (tokens.length == 2) {
                    var opponentHand = Hand.fromABC(tokens[0]);
                    var ownHand = Hand.fromXYZ(tokens[1]);
                    games.add(new SimpleEntry<>(opponentHand, ownHand));
                }
            }
        } catch (IOException e) {
            // Do something
        }
        return games;
    }

    // Uhh
    public static List<SimpleEntry<Hand, Hand>> parseInputBis() {
        List<SimpleEntry<Hand, Hand>> games = new LinkedList<>();
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // A line has the form "A X"
                var tokens = line.split(" ");
                if (tokens.length == 2) {
                    var opponentHand = Hand.fromABC(tokens[0]);
                    var ownToken = tokens[1];
                    games.add(new SimpleEntry<>(
                        opponentHand,
                        switch (ownToken) {
                            case "X" -> opponentHand.winsOver();
                            case "Y" -> opponentHand;
                            case "Z" -> opponentHand.losesOver();
                            default -> null;
                        }));
                }
            }
        } catch (IOException e) {
            // Do something
        }
        return games;
    }

    public static Integer totalPoints(List<SimpleEntry<Hand, Hand>> games) {
        Integer totalPoints = 0;
        for (var game : games) {
            var opponentHand = game.getKey();
            var ownHand = game.getValue();
            totalPoints += ownHand.value();
            if (ownHand == opponentHand) {
                totalPoints += 3;
            } else if (ownHand.winsOver() == opponentHand) {
                totalPoints += 6;
            }
        }
        return totalPoints;
    }

    public static void main(String[] args) {
        System.out.println("Total points (first star): " + totalPoints(parseInput()));
        System.out.println("Total points (second star): " + totalPoints(parseInputBis()));
    }
}
