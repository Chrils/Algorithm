package org.example.D0512;

public class Q115 {

    static class Solution {
        public int numDistinct(String s, String t) {
            // dp[i][j]代表s的前i个字符，t中前j个字符的子序列个数
            // 如果 前i-1个字符中有t的前j-1个字符的子序列，则判断 s[i] == t[1]
            // 是 ： dp[i][j] = dp[i-1][j-1]
            // 否： dp[i][j] = dp[i-1][j] + dp[i][j-1]
            int m = s.length(),n = t.length();
            if (m < n) return 0;
            int[][] dp = new int[m][n];
            int cnt = 0;
            for (int i=0; i<m; i++) {
                if (s.charAt(i) == t.charAt(0)) {
                    cnt++;
                }
                dp[i][0] = cnt;
            }
            for (int i=1; i<m; i++) {
                for (int j=1; j<n && j<=i; j++) {
                    // bbb -> bb = bb -> bb + bbb -> b - 1
                    // bbb -> bc = bb -> bc + bbb -> b
                    // dp[i][j] = dp[i-1][j] + dp[i][j-1] - 1;
                    // 不相等   = dp[i-1][j]
                    if (s.charAt(i) == t.charAt(j)) {
                        // rabbb rab -> rabbb rabb
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[m-1][n-1];
        }
    }

    public static void main(String[] args) {
        int res = new Solution().numDistinct("rabbbit", "rabbit");
        System.out.println("res = " + res);
    }

}
