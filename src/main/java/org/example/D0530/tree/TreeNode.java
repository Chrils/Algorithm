package org.example.D0530.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TreeNode<T> {

    TreeNode<T> left;

    TreeNode<T> right;

    T value;

    public TreeNode() {
    }

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(TreeNode<T> left, TreeNode<T> right, T value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    @Override
    public String toString() {
        return preOrder(this);
    }

    /**
     * root -> left -> right
     *
     * @param root root
     * @param <T>  generic type
     */
    public static <T> String preOrder(TreeNode<T> root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("null");
        } else {
            sb.append(root.value)
                    .append("-")
                    .append(preOrder(root.left))
                    .append("-")
                    .append(preOrder(root.right));
        }
        return sb.toString();
    }

    /**
     * left -> root -> right
     *
     * @param root root
     * @param <T>  generic type
     * @return String format traverse result
     */
    public static <T> String midOrder(TreeNode<T> root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("null");
        } else {
            sb.append(preOrder(root.left))
                    .append("-")
                    .append(root.value)
                    .append("-")
                    .append(preOrder(root.right));
        }
        return sb.toString();
    }

    /**
     * left -> right -> root
     *
     * @param root root
     * @param <T>  generic type
     * @return String format traverse result
     */
    public static <T> String postOrder(TreeNode<T> root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("null");
        } else {
            sb.append(preOrder(root.left))
                    .append("-")
                    .append(preOrder(root.right))
                    .append("-")
                    .append(root.value);
        }
        return sb.toString();
    }

    public static TreeNode<Integer> randomFullIntTree() {
        Random r = new Random();
        TreeNode<Integer> root = new TreeNode<>(r.nextInt(1000));
        final int depth = r.nextInt(6);
        System.out.println("depth = " + depth);
        Queue<TreeNode<Integer>> lastLevel = new LinkedList<>();
        lastLevel.offer(root);
        for (int i = 0; i < depth; i++) {
            int size = lastLevel.size();
            for (int j = 0; j < size; j++) {
                TreeNode<Integer> e = lastLevel.poll();
                TreeNode<Integer> left = new TreeNode<>(r.nextInt(1000));
                TreeNode<Integer> right = new TreeNode<>(r.nextInt(1000));
                e.left = left;
                e.right = right;
                lastLevel.offer(left);
                lastLevel.offer(right);
            }
        }
        return root;
    }

    public static <T> T BFS(TreeNode<T> root,T target) {
        if (target == null) {
            return null;
        }
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            if (node == null) {
                continue;
            }
            if (target.equals(node.value)) {
                return target;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return null;
    }
}
