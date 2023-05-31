package org.example.D0530.tree.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Q547 {

    private static class Solution {

        boolean[] visited = null;

        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            int cnt = 0;
            visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            // isConnected[i][j] == isConnected[j][i]
            // bfs
            for (int i=0; i<n; i++) {
                // 循环每个city，存在未被访问过的时，说明是一个新的省份
                if (!visited[i]) {
                    cnt++;
                    queue.offer(i);
                    while(!queue.isEmpty()) {
                        int e = queue.poll();
                        visited[e] = true;
                        // 找出该城市所有联通的城市进行遍历，bfs、dfs都可
                        for (int j=0; j<isConnected.length; j++) {
                            if (!visited[j] && isConnected[e][j] == 1) {
                                queue.offer(j);
                            }
                        }
                    }
                }
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        int res = new Solution().findCircleNum(new int[][]{
                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
        });
        System.out.println("res = " + res);
    }

}
