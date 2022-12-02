package com.github.relativamenteintelligente.aoc2022.day01;

import static com.github.relativamenteintelligente.aoc2022.day01.Main.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    List<Integer> listCalories;

    {
        try {
            listCalories = readAndSortCaloriesPerElf();
        } catch (IOException e) {
        }
    }

    @Test
    void testGetMaxCalories() {
        assertEquals((Integer) 74198, getMaxCalories(listCalories));
    }

    @Test
    void testGetSumTopThreeCalories() {
        assertEquals((Integer) 209914, getSumTopThreeCalories(listCalories));
    }
}