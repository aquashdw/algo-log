package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2576
public class Prob2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] odds = reader.lines().limit(7)
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 != 0)
                .toArray();
        if (odds.length == 0) {
            System.out.println(-1);
            return;
        }

        int sum = Arrays.stream(odds).sum();
        int min = Arrays.stream(odds).min().orElseThrow();
        System.out.printf("%d%n%d%n", sum, min);
    }
}
