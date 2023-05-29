package org.example.D0526;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {


    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,2,3},{1,1,3},{2,5,1}
        };
        // 假设是最短路径问题
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][] visited = new boolean[3][3];
        visited[0][0] = true;
        queue.offer(new int[]{0,0});
        int level = 0;
        while (!queue.isEmpty()) {
            // 当前层大小
            int size = queue.size();
            // 下一层
            for (int i = 0; i < size; i++) {
                int[] e = queue.poll();
                for (int[] direction : directions) {
                    int x = e[0] + direction[0];
                    int y = e[1] + direction[1];
                    if (x>=0 && y>=0 && x<3 && y<3 && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
            level++;
        }
        System.out.println("level = " + level);
    }

}
