package com.github.relativamenteintelligente.aoc2022.day10;

import java.util.function.Consumer;

public class Cpu {
    private Integer registerX = 1;
    private Integer cycleCount = 0;
    private Consumer<Cpu> debugger;

    public Cpu() {
    }

    public Cpu(Consumer<Cpu> debugger) {
        this.debugger = debugger;
    }

    private void step() {
        cycleCount++;
        if (debugger != null) {
            debugger.accept(this);
        }
    }

    private void noop() {
        step();
    }

    private void addx(Integer V) {
        step();
        step();
        registerX += V;
    }

    public void cycle(Instruction instruction, Object... args) {
        switch (instruction) {
            case NOOP -> noop();
            case ADDX -> addx((Integer) args[0]);
        }
    }

    public Integer signalStrength() {
        return cycleCount * registerX;
    }

    public Integer getRegisterX() {
        return registerX;
    }

    public Integer getCycleCount() {
        return cycleCount;
    }

    @Override
    public String toString() {
        return "Cpu{" +
            "cycleCount=" + cycleCount +
            ", registerX=" + registerX +
            '}';
    }
}
