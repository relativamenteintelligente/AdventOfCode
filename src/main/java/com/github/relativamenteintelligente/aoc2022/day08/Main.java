package com.github.relativamenteintelligente.aoc2022.day08;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    private static final String FILE_NAME = "input/08.txt";

    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new FileReader(FILE_NAME));
        var forest = new Forest(reader);

        System.out.println("Number of visible trees: " + forest.countVisible());
        System.out.println("Highest scenic score: " + forest.highestScenicScore());
    }
}
