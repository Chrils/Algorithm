package org.example.D0526;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public List<Node> children = new ArrayList<>();
    public int val;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(List<Node> children, int val) {
        this.children = children;
        this.val = val;
    }

    public void addNode(Node node) {
        this.children.add(node);
    }

    public void addNode(List<Node> nodes) {
        this.children.addAll(nodes);
    }

    public void traverse() {
        StringBuilder s = new StringBuilder();
        s.append(val);
        List<Node> tmp = children;

    }

}
