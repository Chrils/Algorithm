package org.example.D0530.tree.dfs;

public class Q827 {

    private static class Solution {
        public int largestIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int res = 0;
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (grid[i][j] == 1) {
                        res = Math.max(res,area(grid,i,j,true));
                    }
                }
            }
            return res;
        }

        private int area(int[][] grid,int x,int y,boolean remain) {
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
                return 0;
            }
            if (grid[x][y] == 2) {
                // visited
                return 0;
            }
            if (grid[x][y] == 0) {
                if (remain) {
                    remain = false;
                } else {
                    return 0;
                }
            }
            grid[x][y] = 2;
            return 1 + area(grid,x-1,y,remain)
                    + area(grid,x+1,y,remain)
                    + area(grid,x,y-1,remain)
                    + area(grid,x,y+1,remain);
        }
    }

    public static void main(String[] args) {
        int res = new Solution().largestIsland(new int[][]{
                {1, 0},
                {0, 1}
        });
        System.out.println("res = " + res);
    }

}
