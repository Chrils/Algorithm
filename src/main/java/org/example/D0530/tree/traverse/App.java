package org.example.D0530.tree.traverse;

import org.example.D0530.tree.TreeNode;

import java.util.LinkedHashMap;

public class App {

    public static void main(String[] args) {
        TreeNode<Integer> tree = TreeNode.randomFullIntTree();
        System.out.println(tree);
        System.out.println(1);
        TreeNode.BFS(tree,100);
    }

}
