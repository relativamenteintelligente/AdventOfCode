package com.github.relativamenteintelligente.aoc2022.day07;

public class File extends FileOrDirectory {
    public File(String name, Integer size) {
        super(name, size);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public void add(FileOrDirectory fileOrDirectory) throws Exception {
        throw new Exception("File cannot contain other files or directories.");
    }
}
