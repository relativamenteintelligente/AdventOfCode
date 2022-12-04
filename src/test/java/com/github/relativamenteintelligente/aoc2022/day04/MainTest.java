package com.github.relativamenteintelligente.aoc2022.day04;

import org.junit.Test;

import static com.github.relativamenteintelligente.aoc2022.day04.Main.*;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testPartOne() {
        assertEquals((Long) 573L, partOne());
    }

    @Test
    public void testPartTwo() {
        assertEquals((Long) 867L, partTwo());
    }
}