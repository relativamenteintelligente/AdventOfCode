package com.github.relativamenteintelligente.aoc2022.day02;

public enum Hand {
    ROCK(1), PAPER(2), SCISSOR(3);

    Integer value;

    Hand(int value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }

    public static Hand fromABC(String letter) {
        return switch (letter) {
            case "A" -> ROCK;
            case "B" -> PAPER;
            case "C" -> SCISSOR;
            default -> null;
        };
    }

    public static Hand fromXYZ(String letter) {
        return switch (letter) {
            case "X" -> ROCK;
            case "Y" -> PAPER;
            case "Z" -> SCISSOR;
            default -> null;
        };
    }

    public Hand winsOver() {
        return switch (this) {
            case ROCK -> SCISSOR;
            case PAPER -> ROCK;
            case SCISSOR -> PAPER;
        };
    }

    public Hand losesOver() {
        return winsOver().winsOver();
    }
}
