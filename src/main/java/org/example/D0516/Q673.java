package org.example.D0516;

import java.util.Arrays;

public class Q673 {

    private static class Solution {
        public int findNumberOfLIS(int[] nums) {
            // dp[i]代表以i结尾的最长递增子序列
            // dp[i] = max(dp[j]) + 1
            int max = 1,count = 1;
            int[] dp = new int[nums.length];
            int[] cnt = new int[nums.length];
            Arrays.fill(cnt,1);
            dp[0] = 1;
            for (int i=1,tmpCnt = 1; i<nums.length; ++i) {
                dp[i] = 1;
                for (int j=0; j<i; ++j) {
                    if (nums[i] > nums[j]) {
                        if (dp[j]+1 == dp[i]) {
                            tmpCnt += cnt[j];
                        } else {
                            tmpCnt = cnt[j];
                        }
                        dp[i] = Math.max(dp[i] , dp[j]+1);
                    }
                }
                cnt[i] = tmpCnt;
                if (dp[i] > max) {
                    max = dp[i];
                    count = cnt[i];
                } else if (dp[i] == max) {
                    count += cnt[i];
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int res = new Solution().findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2});
        System.out.println("res = " + res);
    }

}
