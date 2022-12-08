package com.github.relativamenteintelligente.aoc2022.day08;

public class Tree {
    private final Integer height;

    private Tree top;
    private Tree right;
    private Tree bottom;
    private Tree left;

    private Integer memoizedHighestTop;
    private Integer memoizedHighestRight;
    private Integer memoizedHighestBottom;
    private Integer memoizedHighestLeft;

    public Tree(Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return height;
    }

    public Tree getTop() {
        return top;
    }

    public void setTop(Tree top) {
        this.top = top;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public Tree getBottom() {
        return bottom;
    }

    public void setBottom(Tree bottom) {
        this.bottom = bottom;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree topMost() {
        return top == null ? this : top.topMost();
    }

    public Tree leftMost() {
        return left == null ? this : left.leftMost();
    }

    private Integer highestTop() {
        if (memoizedHighestTop != null) {
            return memoizedHighestTop;
        }
        if (top == null) {
            memoizedHighestTop = -1;
            return memoizedHighestTop;
        }
        memoizedHighestTop = Math.max(top.getHeight(), top.highestTop());
        return memoizedHighestTop;
    }

    public Integer highestRight() {
        if (memoizedHighestRight != null) {
            return memoizedHighestRight;
        }
        if (right == null) {
            memoizedHighestRight = -1;
            return memoizedHighestRight;
        }
        memoizedHighestRight = Math.max(right.getHeight(), right.highestRight());
        return memoizedHighestRight;
    }

    public Integer highestBottom() {
        if (memoizedHighestBottom != null) {
            return memoizedHighestBottom;
        }
        if (bottom == null) {
            memoizedHighestBottom = -1;
            return memoizedHighestBottom;
        }
        memoizedHighestBottom = Math.max(bottom.getHeight(), bottom.highestBottom());
        return memoizedHighestBottom;
    }

    public Integer highestLeft() {
        if (memoizedHighestLeft != null) {
            return memoizedHighestLeft;
        }
        if (left == null) {
            memoizedHighestLeft = -1;
            return memoizedHighestLeft;
        }
        memoizedHighestLeft = Math.max(left.getHeight(), left.highestLeft());
        return memoizedHighestLeft;
    }

    public boolean isVisible() {
        return height > highestTop()
            || height > highestRight()
            || height > highestBottom()
            || height > highestLeft();
    }

    // For the second star
    private Integer underTop() {
        Integer result = 0;
        for (var tree = top; tree != null; tree = tree.getTop()) {
            result++;
            if (tree.getHeight() >= height) {
                break;
            }
        }
        return result;
    }

    private Integer underRight() {
        Integer result = 0;
        for (var tree = right; tree != null; tree = tree.getRight()) {
            result++;
            if (tree.getHeight() >= height) {
                break;
            }
        }
        return result;
    }

    private Integer underBottom() {
        Integer result = 0;
        for (var tree = bottom; tree != null; tree = tree.getBottom()) {
            result++;
            if (tree.getHeight() >= height) {
                break;
            }
        }
        return result;
    }

    private Integer underLeft() {
        Integer result = 0;
        for (var tree = left; tree != null; tree = tree.getLeft()) {
            result++;
            if (tree.getHeight() >= height) {
                break;
            }
        }
        return result;
    }

    public Integer scenicScore() {
        return underTop()
            * underRight()
            * underBottom()
            * underLeft();
    }
}
