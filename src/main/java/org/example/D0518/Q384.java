package org.example.D0518;

import java.util.Arrays;
import java.util.Comparator;

public class Q384 {

    private static class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            Arrays.sort(envelopes,(e1, e2) -> {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            });
            // 贪心 + 二分
            // 每次找出当前位置可以存放的最小值
            int[][] arr = new int[n+1][2];
            arr[0][0] = envelopes[0][0];
            arr[0][1] = envelopes[0][1];
            int pos = 0;
            for (int i=1; i<n; i++) {
                int x = envelopes[i][0];
                int y = envelopes[i][1];
                if (x > arr[pos][0] && y > arr[pos][1]) {
                    arr[++pos][0] = x;
                    arr[pos][1] = y;
                } else {
                    int idx = binarySearch(arr,pos,y);
                    if (y < arr[idx][1]) {
                        arr[idx][0] = x;
                        arr[idx][1] = y;
                    }
                }
            }
            return pos+1;
        }

        private int binarySearch(int[][] arr,int len,int target) {
            int l = 0,r = len,mid = 0;
            while (l < r) {
                mid = (l+r) >>> 1;
                if (arr[mid][1] >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        int res = new Solution().maxEnvelopes(new int[][]{
                new int[]{2,100},
                new int[]{3,200},
                new int[]{4,300},
                new int[]{5,500},
                new int[]{5,400},
                new int[]{5,250},
                new int[]{6,370},
                new int[]{6,360},
                new int[]{7,380}
        });
        System.out.println("res = " + res);
    }

}
