package com.github.relativamenteintelligente.aoc2022.day07;

import java.util.ArrayList;
import java.util.List;

public class ElfSystem {
    private FileOrDirectory root;
    private FileOrDirectory currentWorkingDirectory;

    public ElfSystem() {
        root = new Directory("");
        currentWorkingDirectory = root;
    }

    private void changeDirectory(String argument) throws Exception {
        switch (argument) {
            case "/": {
                currentWorkingDirectory = root;
                break;
            }
            case "..": {
                if (currentWorkingDirectory.isRoot()) {
                    throw new Exception("Cannot change directory above root.");
                }
                currentWorkingDirectory = currentWorkingDirectory.getParent();
                break;
            }
            default: {
                var newDirectory = currentWorkingDirectory.getChildren().parallelStream()
                    .filter(child -> child.getName().equals(argument))
                    .findAny();
                if (newDirectory.isEmpty()) {
                    throw new Exception("Cannot change directory to one that does not exist.");
                }
                currentWorkingDirectory = newDirectory.get();
            }
        }
    }

    private void reverseLs(List<String> lines) throws Exception {
        for (var line : lines) {
            var tokens = line.split(" ");
            if (tokens.length != 2) {
                throw new IllegalArgumentException("Illegal ls format.");
            }

            if (tokens[0].equals("dir")) {
                currentWorkingDirectory.add(new Directory(tokens[1]));
            } else {
                currentWorkingDirectory.add(new File(tokens[1], Integer.parseInt(tokens[0])));
            }
        }
    }

    public void syncronize(List<String> commandAndOutput) throws Exception {
        /* Assuming that
            1. commandAndOutput is not null
            2. commandAndOutput is not empty
            3. strings are not null
         */
        var fullCommand = commandAndOutput.get(0);
        var outputLines = commandAndOutput.subList(1, commandAndOutput.size());
        if (fullCommand.length() < 3 || !fullCommand.startsWith("$ ")) {
            throw new IllegalArgumentException("Ill formatted command!");
        }

        var commandAndArgument = fullCommand.substring(2).split(" ", 2);
        var command = commandAndArgument[0];
        var argument = commandAndArgument.length > 1 ? commandAndArgument[1] : null;

        switch (command) {
            case "cd" -> changeDirectory(argument);
            case "ls" -> reverseLs(outputLines);
            default -> throw new IllegalArgumentException("Unknown command.");
        }
    }

    public FileOrDirectory getRoot() {
        return root;
    }

    public FileOrDirectory getCurrentWorkingDirectory() {
        return currentWorkingDirectory;
    }

    public List<Directory> getAllDirectories() {
        List<Directory> directories = new ArrayList<>();
        var level = new ArrayList<Directory>();
        level.add((Directory) root);
        while (!level.isEmpty()) {
            directories.addAll(level);
            var sublevel = new ArrayList<Directory>();
            for (var directory : level) {
                for (var child : directory.getChildren()) {
                    if (child instanceof Directory childDirectory) {
                        sublevel.add(childDirectory);
                    }
                }
            }
            level = sublevel;
        }
        return directories;
    }
}
