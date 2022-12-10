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
        switch (direction) {
            case UP    -> position.setY(position.getY() + 1);
            case LEFT  -> position.setX(position.getX() - 1);
            case DOWN  -> position.setY(position.getY() - 1);
            case RIGHT -> position.setX(position.getX() + 1);
        }
        return this;
    }

    public Double distance(Knot that) {
        var dx = this.position.getX() - that.position.getX();
        var dy = this.position.getY() - that.position.getY();
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
