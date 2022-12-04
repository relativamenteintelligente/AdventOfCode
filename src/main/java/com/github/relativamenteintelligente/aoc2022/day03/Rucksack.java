package com.github.relativamenteintelligente.aoc2022.day03;

import java.util.List;

public class Rucksack {
    private final List<Byte> items;
    private final Integer numberOfItems;

    public Rucksack(List<Byte> items) {
        this.items = items;
        numberOfItems = items.size();
    }

    public List<Byte> getItems() {
        return items;
    }

    public List<Byte> getFirstCompartment() {
        return items.subList(0, numberOfItems / 2);
    }

    public List<Byte> getSecondCompartment() {
        return items.subList(numberOfItems / 2, numberOfItems);
    }

    public List<Byte> getCommonItems() {
        return getFirstCompartment().stream()
            .filter(getSecondCompartment()::contains)
            .toList();
    }
}
