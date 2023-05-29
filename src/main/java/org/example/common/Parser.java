package org.example.common;

public class Parser {

    public static int[] iptArr(String src) {
        if (src.length() <= 2) {
            return new int[0];
        }
        int begin = src.indexOf("[");
        int end = src.indexOf("]");
        String substring = src.substring(begin + 1, end);
        String[] stirs = substring.split(",");
        int[] res = new int[stirs.length];
        for (int i = 0; i < stirs.length; i++) {
            res[i] = Integer.parseInt(stirs[i]);
        }
        return res;
    }

}
