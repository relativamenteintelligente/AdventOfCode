package com.github.relativamenteintelligente.aoc2022.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Forest {
    Tree root;

    public Forest(BufferedReader reader) throws IOException {
        Tree left = null;
        Tree top = null;

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isBlank()) {
                continue;
            }
            for (var heightAsChar : line.getBytes()) {
                var current = new Tree(heightAsChar - '0');
                if (left != null) {
                    current.setLeft(left);
                    left.setRight(current);
                }
                if (top != null) {
                    current.setTop(top);
                    top.setBottom(current);
                    top = top.getRight();
                }
                left = current;
            }
            assert left != null;
            top = left.leftMost();
            left = null;
        }
        assert top != null;
        root = top.topMost();
    }

    public Iterator<Tree> iterator() {
        return new Itr();
    }

    // Note: forest always have at least one tree
    private class Itr implements Iterator<Tree> {
        private Tree current = root;
        private boolean hasNext = true;

        @Override
        public boolean hasNext() {
            return hasNext;
        }

        private void advance() throws NoSuchElementException {
            if (!hasNext) {
                throw new NoSuchElementException();
            }
            Tree next;
            if ((next = current.getRight()) != null) {
                current = next;
            } else if ((next = current.leftMost().getBottom()) != null) {
                current = next;
            } else {
                hasNext = false;
            }

        }

        @Override
        public Tree next() {
            Tree result = current;
            advance();
            return result;
        }
    }

    public Integer countVisible() {
        var result = 0;
        var it = iterator();
        while (it.hasNext()) {
            if (it.next().isVisible()) {
                result++;
            }
        }
        return result;
    }

    // For the second star
    public Integer highestScenicScore() {
        var result = 0;
        var it = iterator();
        while (it.hasNext()) {
            var nextScenicScore = it.next().scenicScore();
            if (nextScenicScore > result) {
                result = nextScenicScore;
            }
        }
        return result;
    }
}
