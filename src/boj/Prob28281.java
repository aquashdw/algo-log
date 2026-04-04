package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/28281
public class Prob28281 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nx = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] prices = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < nx[0] - 1; i++) {
            int aCost = prices[i] * nx[1];
            int bCost = prices[i + 1] * nx[1];
            minSum = Math.min(minSum, aCost + bCost);
        }
        System.out.println(minSum);
    }
}
