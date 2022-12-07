package com.github.relativamenteintelligente.aoc2022.day07;

public class Directory extends FileOrDirectory {
    public Directory(String name) {
        super(name, 0);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public void add(FileOrDirectory fileOrDirectory) throws Exception {
        var children = getChildren();

        if (children.stream()
            .anyMatch(child -> child.getName().equals(fileOrDirectory.getName()))) {
            throw new Exception("File of directory already present.");
        }

        children.add(fileOrDirectory);
        fileOrDirectory.setParent(this);

        if (fileOrDirectory instanceof File) {
            var fileSize = fileOrDirectory.getSize();
            for (FileOrDirectory directory = this; directory != null; directory = directory.getParent()) {
                directory.setSize(directory.getSize() + fileSize);
            }
        }
    }
}
