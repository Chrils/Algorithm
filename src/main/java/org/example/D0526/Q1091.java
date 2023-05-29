package org.example.D0526;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Q1091 {

    private static class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            int[][] dp = new int[n][n];
            dp[0][0] = 1; // 只有一个元素，只要不为1，显然存在最短路径
            int[][] directions = new int[][] {
                    {0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}
            };
            boolean[][] visited = new boolean[n][n];
            visited[0][0] = true;
            if (grid[0][0] == 1) {
                return -1;
            }
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{0,0});
            while(!queue.isEmpty()) { // bfs
                int size = queue.size();
                int[] e = queue.poll();
                for (int i=0; i<size; i++) {
                    for (int[] d : directions) {
                        int x = e[0] + d[0];
                        int y = e[1] + d[1];
                        if (x>=0 && y>=0 && x<n && y<n && !visited[x][y]
                                && grid[x][y] == 0) {
                            visited[x][y] = true;
                            dp[x][y] = dp[e[0]][e[1]] + 1;
                            queue.offer(new int[]{x,y});
                        }
                    }
                }
            }
            return dp[n-1][n-1] == 0 ? -1 : dp[n-1][n-1];
        }
    }

    public static void main(String[] args) {
        int[][] ints = {
                new int[]{1, 0, 0},
                new int[]{1, 1, 0},
                new int[]{1, 1, 0}
        };
        int res = new Solution().shortestPathBinaryMatrix(ints);
        System.out.println("res = " + res);
    }

}
