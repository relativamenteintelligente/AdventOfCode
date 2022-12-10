package com.github.relativamenteintelligente.aoc2022.day09;

public enum Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT;

    public static Direction fromString(String direction) {
        return switch (direction) {
            case "U" -> UP;
            case "R" -> RIGHT;
            case "D" -> DOWN;
            case "L" -> LEFT;
            default -> throw new IllegalArgumentException();
        };
    }
}
