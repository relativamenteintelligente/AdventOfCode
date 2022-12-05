package com.github.relativamenteintelligente.aoc2022.day05;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CoolCargoCrane extends CargoCrane {

    public CoolCargoCrane(List<String> lines) {
        super(lines);
    }

    @Override
    public void move(Integer n, Integer from, Integer to) {
        Deque<String> tempList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            tempList.push(stacks.get(from - 1).pop());
        }
        for (int i = 0; i < n; i++) {
            stacks.get(to - 1).push(tempList.pop());
        }
    }
}
