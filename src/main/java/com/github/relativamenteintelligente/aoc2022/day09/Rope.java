package com.github.relativamenteintelligente.aoc2022.day09;

import java.util.ArrayList;
import java.util.List;

public class Rope {
    private final Integer ropeLength;
    private List<Knot> knots;

    // keep memory of all tail positions
    private List<Point> tailPositions = new ArrayList<>();

    public Rope() {
        this(2);
    }

    public Rope(Integer ropeLength) {
        this.ropeLength = ropeLength;
        knots = new ArrayList<>(ropeLength);
        for (int i = 0; i < ropeLength; i++) {
            knots.add(new Knot(new Point(0, 0)));
        }
        // no need to add initial tail position
    }

    public Knot getHead() {
        return knots.get(0);
    }

    public Knot getTail() {
        return knots.get(ropeLength - 1);
    }

    public void move(Direction direction) {
        getHead().move(direction);
        for (int i = 1; i < ropeLength; i++) {
            knots.get(i).update(knots.get(i - 1));
        }
        tailPositions.add(getTail().position);
    }

    public Integer numberOfUniqueTailPositions() {
        return (int) tailPositions.stream()
            .distinct()
            .count();
    }

    @Override
    public String toString() {
        return String.join("-", knots.stream().map(k -> k.getPosition().toString()).toList());
    }
}
