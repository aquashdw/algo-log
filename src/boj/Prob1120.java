package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1120
public class Prob1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = reader.readLine().split(" ");
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < strs[1].length() - strs[0].length() + 1; i++) {
            int diff = 0;
            for (int j = 0; j < strs[0].length(); j++) {
                if (strs[0].charAt(j) != strs[1].charAt(i + j)) diff++;
            }
            minDiff = Math.min(minDiff, diff);
        }
        System.out.println(minDiff);
    }
}
