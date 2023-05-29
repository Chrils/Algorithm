package org.example.D0516;

import java.util.Arrays;
import java.util.Comparator;

public class Q704 {

    private static class Solution {
        public int search(int[] nums, int target) {
            int l = 0,r = nums.length - 1,mid = 0;
            while (l < r) {
                mid = (l+r) >> 1;
                if (nums[mid] > target) {
                    r = mid - 1;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] ints1 = {new int[]{-2, 1}, new int[]{3, 7}, new int[]{0, 10}, new int[]{-1, 8},
                new int[]{0, 7}, new int[]{8, 9}, new int[]{7, 10}, new int[]{-9, -3}, new int[]{-4, -3}
                , new int[]{0, 6}};
        int[] a = {1, 2};
        int[] b = {3, 4};
        int[] c = {2, 3};
        int[][] ints = {b, a,c};
        Arrays.sort(ints1, Comparator.comparingInt(x -> x[0]));
        System.out.println("ints1 = " + Arrays.deepToString(ints1));
    }

}
