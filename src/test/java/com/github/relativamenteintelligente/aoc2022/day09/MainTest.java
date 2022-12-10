package com.github.relativamenteintelligente.aoc2022.day09;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.*;

public class MainTest {
    BufferedReader reader = new BufferedReader(
        new StringReader(
            """
                R 5
                U 8
                L 8
                D 3
                R 17
                D 10
                L 25
                U 20"""
        ));

    @Test
    public void numberOfUniqueTailPositions() {
        assertEquals((Integer) 36, Main.numberOfUniqueTailPositions(reader, 10));
    }
}