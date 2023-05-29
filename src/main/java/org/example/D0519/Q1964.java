package org.example.D0519;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q1964 {

    private static class Solution {
        public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
            // 从第n个数开始，前序遍历找出尽可能大的数
            int n = obstacles.length;
            List<Integer> list = new ArrayList<>();
            int[] dp = new int[n];
            list.add(obstacles[0]);
            dp[0] = 1;
            // 使落入的每个数尽可能大
            for (int i=1; i<n; i++) {
                if (obstacles[i] >= list.get(list.size()-1)) {
                    list.add(obstacles[i]);
                    dp[i] = list.size();
                } else {
                    int idx = binarySearch(list,obstacles[i]);
//                    list.add(idx,obstacles[i]);
                    dp[i] = idx+1;
                }
            }
            return dp;
        }

        private int binarySearch(List<Integer> list,int target) {
            int l = 0,r = list.size(),mid = 0;
            while (l < r) {
                mid = (l+r) >>> 1;
                if (list.get(mid) > target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        int[] res = new Solution().longestObstacleCourseAtEachPosition(new int[]{1,2,3,2});
        System.out.println(Arrays.toString(res));
    }

}
