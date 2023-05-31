package org.example.D0530.tree.dfs;

public class Q695 {

    private static class Solution {

        boolean[][] visited = null;

        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int res = 0;
            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        res = Math.max(res, area(grid, i, j));
                    }
                }
            }
            return res;
        }

        private int area(int[][] grid, int x, int y) {
            int m = grid.length;
            int n = grid[0].length;
            // base case
            if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) {
                return 0;
            }
            if (grid[x][y] == 0) {
                return 0;
            }
            visited[x][y] = true;
            return 1 + area(grid, x - 1, y)
                    + area(grid, x + 1, y)
                    + area(grid, x, y - 1)
                    + area(grid, x, y + 1);
        }
    }

    public static void main(String[] args) {
        int res = new Solution().maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        });
        System.out.println("res = " + res);
    }

}
