package com.github.relativamenteintelligente.aoc2022.day09;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rope {
    private Knot head;
    private Knot tail;

    // hacky way
    private Set<Integer> tailPositions = new HashSet<>(List.of(0));

    public Rope() {
        head = new Knot(new Point(0, 0));
        tail = new Knot(new Point(0, 0));
    }

    public Knot getHead() {
        return head;
    }

    public Knot getTail() {
        return tail;
    }

    public void move(Direction direction) {
        head.move(direction);
        tail.update(head);

        // hack!
        var tailPosition = tail.position;
        tailPositions.add(tailPosition.getX() * 10000 + tailPosition.getY());
    }

    public Integer numberOfUniqueTailPositions() {
        return tailPositions.size();
    }
}
