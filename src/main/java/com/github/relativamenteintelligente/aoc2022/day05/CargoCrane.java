package com.github.relativamenteintelligente.aoc2022.day05;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CargoCrane {
    protected Integer numberOfStacks;
    protected List<Deque<String>> stacks;

    public CargoCrane(Integer numberOfStacks) {
        this.numberOfStacks = numberOfStacks;
        stacks = new ArrayList<>(numberOfStacks);
        for (int i = 0; i < numberOfStacks; i++) {
            stacks.add(new LinkedList<>());
        }
    }

    public CargoCrane(List<String> lines) {
        this((lines.get(0).length() + 1) / 4);
        for (int i = lines.size() - 2; i >= 0; i--) {
            addStackLine(lines.get(i));
        }
    }

    public void move(Integer n, Integer from, Integer to) {
        for (int i = 0; i < n; i++) {
            stacks.get(to - 1).push(
                stacks.get(from - 1).pop());
        }
    }

    public void move(String line) {
        var tokens = line.split(" ");
        var n = Integer.parseInt(tokens[1]);
        var from = Integer.parseInt(tokens[3]);
        var to = Integer.parseInt(tokens[5]);
        move(n, from, to);
    }

    public List<String> getTopCrates() {
        List<String> crates = new ArrayList<>(numberOfStacks);
        for (int i = 0; i < numberOfStacks; i++) {
            crates.add(stacks.get(i).peek());
        }
        return crates;
    }

    @Override
    public String toString() {
        return "TO IMPLEMENT";
    }

    public void addStackLine(String line) {
        for (int stackIndex = 0; stackIndex < numberOfStacks; stackIndex++) {
            var crane = String.valueOf(line.charAt(stackIndex * 4 + 1));
            if (!crane.equals(" ")) {
                stacks.get(stackIndex).push(crane);
            }
        }
    }
}
