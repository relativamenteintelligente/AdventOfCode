package com.github.relativamenteintelligente.aoc2022.day09;

import java.util.Comparator;
import java.util.stream.Stream;

public class Knot {
    Point position;

    public Knot(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public Knot move(Direction direction) {
        position = switch (direction) {
            case UP -> new Point(position.x(), position.y() + 1);
            case RIGHT -> new Point(position.x() + 1, position.y());
            case DOWN -> new Point(position.x(), position.y() - 1);
            case LEFT -> new Point(position.x() - 1, position.y());
        };
        return this;
    }

    public Double distance(Knot that) {
        var dx = this.position.x() - that.position.x();
        var dy = this.position.y() - that.position.y();
        return Math.sqrt((double) dx * dx + dy * dy);
    }

    protected Knot copy() {
        return new Knot(position.copy());
    }

    private Stream<Knot> neighbours() {
        return Stream.of(copy().move(Direction.UP),
            copy().move(Direction.RIGHT),
            copy().move(Direction.DOWN),
            copy().move(Direction.LEFT),
            copy().move(Direction.UP).move(Direction.LEFT),
            copy().move(Direction.UP).move(Direction.RIGHT),
            copy().move(Direction.DOWN).move(Direction.LEFT),
            copy().move(Direction.DOWN).move(Direction.RIGHT)
        );
    }

    public void update(Knot head) {
        if (distance(head) >= 2) {
            position = neighbours()
                .min(Comparator.comparingDouble(k -> k.distance(head)))
                .orElseThrow()
                .position
                .copy();
        }
    }
}
