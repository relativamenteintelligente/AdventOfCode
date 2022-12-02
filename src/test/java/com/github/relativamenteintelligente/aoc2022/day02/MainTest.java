package com.github.relativamenteintelligente.aoc2022.day02;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.List;

import static com.github.relativamenteintelligente.aoc2022.day02.Main.*;
import static org.junit.Assert.*;

class MainTest {
    private List<AbstractMap.SimpleEntry<Hand, Hand>> games;

    @Test
    void testTotalPoints() {
        games = parseInput();
        assertEquals((Integer) 13009, totalPoints(games));
    }

    // Oh dear
    @Test
     void testTotalPointsBis() {
        games = parseInputBis();
        assertEquals((Integer) 10398, totalPoints(games));
    }
}