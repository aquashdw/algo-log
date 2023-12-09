package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1149
public class Prob1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] colorCosts = new int[n][];
        for (int i = 0; i < n; i++) {
            colorCosts[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] minCosts = new int[n][3];
        minCosts[0] = colorCosts[0];
        for (int i = 1; i < n; i++) {
            minCosts[i][0] = Math.min(minCosts[i - 1][1], minCosts[i - 1][2]) + colorCosts[i][0];
            minCosts[i][1] = Math.min(minCosts[i - 1][0], minCosts[i - 1][2]) + colorCosts[i][1];
            minCosts[i][2] = Math.min(minCosts[i - 1][0], minCosts[i - 1][1]) + colorCosts[i][2];
        }

        int min = Math.min(minCosts[n - 1][0], minCosts[n - 1][1]);
        min = Math.min(minCosts[n - 1][2], min);
        System.out.println(min);
    }
}
