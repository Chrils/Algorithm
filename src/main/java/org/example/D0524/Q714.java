package org.example.D0524;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.common.Parser.iptArr;

public class Q714 {

    private static class Solution {
        public int maxProfit(int[] prices, int fee) {
            // dp[i]代表第i天股票的利润 0 卖出 1 持有
            // 第i天卖出 dp[i][0] = dp[i-1][1] + prices[i] - fee
            // 第i天持有 dp[i][1] = Math.max(dp[i-1][0] - prices[i] , dp[i-1][1])
            int n = prices.length;
            int f1 = 0,f2 = -prices[0];
            for (int i=1; i<n; i++) {
                int temp = f2;
                f2 = Math.max(f1-prices[i],f2);
                f1 = temp + prices[i] - fee;
            }
            return f1;
        }
    }

    public static void main(String[] args) {
        int res = new Solution().maxProfit(iptArr("[1,3,7,5,10,3]"), 3);
        System.out.println("res = " + res);
    }

    public static List<String> output(Object src) {
        Class<?> clazz = src.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        return Arrays.stream(methods).peek(m -> m.setAccessible(true))
                .map(Method::getName)
                .collect(Collectors.toList());

    }

}
