package com.github.relativamenteintelligente.aoc2022.day05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final String FILE_NAME = "input/05.txt";


    private static CargoCrane parseInput(boolean isCool) {
        CargoCrane cargoCrane = null;
        try (var reader = new BufferedReader(new FileReader(FILE_NAME))) {
            var cargoLines = new ArrayList<String>();

            String line;
            while (!(line = reader.readLine()).equals("")) {
                cargoLines.add(line);
            }
            cargoCrane = isCool
                ? new CoolCargoCrane(cargoLines)
                : new CargoCrane(cargoLines);

            while ((line = reader.readLine()) != null) {
                cargoCrane.move(line);
            }
        } catch (IOException e) {
            System.out.println("Couldn't parse input");
            System.exit(1);
        }
        return cargoCrane;
    }

    public static void main(String[] args) {
        var cargoCrane = parseInput(false);
        var coolCargoCrane = parseInput(true);
        System.out.println("CrateMover 9000: " + String.join("", cargoCrane.getTopCrates()));
        System.out.println("CrateMover 9001: " + String.join("", coolCargoCrane.getTopCrates()));
    }
}
