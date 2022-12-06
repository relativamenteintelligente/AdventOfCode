package com.github.relativamenteintelligente.aoc2022.day06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CircularArray {
    private Integer index;
    private Integer size;
    private Integer counter;
    private List<Integer> integerList;

    public CircularArray(Integer size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Circular array must have positive size.");
        }
        this.index = 0;
        this.size = size;
        this.counter = 0;
        integerList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            integerList.add(null);
        }
    }

    public void add(Integer n) {
        integerList.set(index, n);
        index = (index + 1) % size;
        counter++;
    }

    public boolean distinct() {
        return integerList.stream()
            .filter(Objects::nonNull)
            .distinct()
            .count() == size;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return integerList.toString();
    }
}
