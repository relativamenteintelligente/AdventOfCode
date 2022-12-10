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
            case LEFT -> new Point(position.x() - 1, position.y());
            case DOWN -> new Point(position.x(), position.y() - 1);
            case RIGHT -> new Point(position.x() + 1, position.y());
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

    public void update(Knot head) {
        // if the tail is distant from the head then move to the closest
        // position to it
        if (distance(head) >= 2) {
            position = Stream.of(head.copy().move(Direction.UP),
                    head.copy().move(Direction.RIGHT),
                    head.copy().move(Direction.DOWN),
                    head.copy().move(Direction.LEFT))
                .min(Comparator.comparingDouble(k -> k.distance(this)))
                .orElseThrow()
                .position
                .copy();
        }
    }
}
