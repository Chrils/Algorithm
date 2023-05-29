package org.example.D0519;

public class Q1143 {

    private static class Solution {
        public int method1(String text1, String text2) {
            //dp[i][j] = dp[i-1][j-1] + 1    ci==cj
            //           dp[i][j-1]
            int m = text1.length();
            int n = text2.length();
            if (m == 0 || n == 0) {
                return 0;
            }
            int[] dp = new int[n];
            int temp = 0,prev = 0;
            // 从text1第一个字符开始，相等则text2前n个字符与其公共子序列都为text1
            int idx = text2.indexOf(text1.charAt(0));
            if (idx >= 0) {
                for (int i=idx; i<n; i++) {
                    dp[i] = 1;
                }
            }
            for (int i=1; i<m; i++ ) {
                char c2 = text2.charAt(0);
                prev = dp[0];
                if (text1.indexOf(c2) >= 0 && text1.indexOf(c2) <= i) {
                    dp[0] = 1;
                }
                for (int j=1; j<n; j++ ) {
                    temp = dp[j];
                    if (text1.charAt(i) == text2.charAt(j)) {
                        dp[j] = prev + 1;
                    } else {
                        dp[j] = dp[j-1];
                    }
                    prev = temp;
                }
            }
            return dp[n-1];
        }

        public int method2(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
            if (m == 0 || n == 0) {
                return 0;
            }
            int[][] dp = new int[m+1][n+1];

            for (int i=1; i<=m; i++) {
                for (int j=1; j<=n; j++) {
                    if (text1.charAt(i-1) == text2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                    }
                }
            }

            return dp[m][n];
        }
    }

    public static void main(String[] args) {
        int res = new Solution().method2("abcde", "ace");
        System.out.println("res = " + res);
    }

}
