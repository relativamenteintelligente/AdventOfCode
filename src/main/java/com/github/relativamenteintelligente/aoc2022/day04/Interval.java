package com.github.relativamenteintelligente.aoc2022.day04;

public class Interval {
    private Integer start;
    private Integer end;

    public Interval(Integer start, Integer end) {
        if (start > end) {
            throw new IllegalArgumentException("Start must be less or equal to end.");
        }
        this.start = start;
        this.end = end;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public Boolean fullyContains(Interval other) {
        return this.getStart() <= other.getStart() &&
            other.getEnd() <= this.getEnd();
    }

    public Boolean fullyOverlapsWith(Interval other) {
        return this.fullyContains(other) || other.fullyContains(this);
    }

    public Boolean contains(Integer i) {
        return start <= i && i <= end;
    }

    public Boolean overlapsWith(Interval other) {
        return this.contains(other.getStart()) || other.contains(this.getStart());
    }

    @Override
    public String toString() {
        return start + "-" + end;
    }

    public static Interval fromString(String string) {
        var ends = string.split("-");
        if (ends.length != 2) {
            throw new IllegalArgumentException("Ill formatted interval.");
        }
        return new Interval(Integer.parseInt(ends[0]), Integer.parseInt(ends[1]));
    }
}
