package com.toi.mobile.Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    protected char id;
    protected char parentId;
    protected String name;

    protected char start;

    protected char end;

    protected List<TreeNode> children = new ArrayList<>();

    public void add(TreeNode node) {
        children.add(node);
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public char getParentId() {
        return parentId;
    }

    public void setParentId(char parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public char getStart() {
        return start;
    }

    public void setStart(char start) {
        this.start = start;
    }

    public char getEnd() {
        return end;
    }

    public void setEnd(char end) {
        this.end = end;
    }
}
