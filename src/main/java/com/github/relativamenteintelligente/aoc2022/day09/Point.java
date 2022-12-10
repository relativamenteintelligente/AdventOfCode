package com.github.relativamenteintelligente.aoc2022.day09;

public record Point(int x, int y) {
    public Point copy() {
        return new Point(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point other) {
            return x == other.x && y == other.y;
        }
        return false;
    }
}
