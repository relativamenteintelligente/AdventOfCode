package p01;

import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader reader;
    static {
        try {
            reader = new BufferedReader(new FileReader("src/p01/input01.txt"));
        } catch (Exception e) {
            System.exit(1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        Integer partialResult = 0, maxResult = 0;
        List<Integer> allResults = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            try {
                partialResult += Integer.parseInt(line);
            } catch (NumberFormatException e) {
                maxResult = Math.max(maxResult, partialResult);
                allResults.add(partialResult);
                partialResult = 0;
            }
        }
        // Star 1
        System.out.println("Maximum amount of calories carried by an elf: " + maxResult);

        // Star 2
        allResults.sort((Integer n1, Integer n2) -> n2 - n1);
        var first = allResults.get(0);
        var second = allResults.get(1);
        var third = allResults.get(2);
        System.out.println("Sum of calories carried by the top three elves: " + (first + second + third));
    }
}
