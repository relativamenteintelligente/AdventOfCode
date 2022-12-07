package com.github.relativamenteintelligente.aoc2022.day07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class FileOrDirectory {
    private String name;
    private Integer size;
    private FileOrDirectory parent;
    private List<FileOrDirectory> children;

    public abstract boolean isDirectory();

    public abstract void add(FileOrDirectory fileOrDirectory) throws Exception;

    protected FileOrDirectory(String name, Integer size) {
        this.name = name;
        this.size = size;
        children = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public Integer getSize() {
        return size;
    }

    public String fullPath() {
        var firNames = new ArrayList<String>();
        for (var fir = this; fir != null; fir = fir.getParent()) {
            firNames.add(fir.getName());
        }
        Collections.reverse(firNames);
        return String.join("/", firNames);
    }

    public FileOrDirectory getParent() {
        return parent;
    }

    public List<FileOrDirectory> getChildren() {
        return children;
    }

    protected void setSize(Integer size) {
        this.size = size;
    }

    protected void setParent(FileOrDirectory parent) {
        this.parent = parent;
    }

    public boolean isRoot() {
        return parent == null;
    }
}
