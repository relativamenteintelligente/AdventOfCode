package com.github.relativamenteintelligente.aoc2022.day08;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.*;

public class ForestTest {
    Forest forest;
    Tree root;

    @Before
    public void setUp() throws Exception {
        forest = new Forest(new BufferedReader(new StringReader(
            """
            30373
            25512
            65332
            33549
            35390
            """)));
        root = forest.root;
    }

    @Test
    public void forest() {
        assertEquals((Integer) 3, forest.root.getHeight());
        assertEquals((Integer) 0, forest.root.getRight().getHeight());
        assertEquals((Integer) 2, forest.root.getBottom().getHeight());
        assertEquals((Integer) 7, forest.root.highestRight());
    }

    @Test
    public void countVisible() {
        assertEquals((Integer) 21, forest.countVisible());
    }

    @Test
    public void highestScenicScore() {
        assertEquals((Integer) 8, forest.highestScenicScore());
    }
}