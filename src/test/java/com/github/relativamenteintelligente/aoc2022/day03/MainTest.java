package com.github.relativamenteintelligente.aoc2022.day03;

import org.junit.Test;

import static com.github.relativamenteintelligente.aoc2022.day03.Main.*;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testItemPriority() {
        Byte b = 'p';
        assertEquals((Integer) 16, itemPriority(b));
        b = 'P';
        assertEquals((Integer) 42, itemPriority(b));
    }

    @Test
    public void testPartOne() {
        assertEquals((Integer) 7903, partOne());
    }

    @Test
    public void testPartTwo() {
        assertEquals((Integer) 2548, partTwo());
    }
}