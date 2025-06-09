package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2953
public class Prob2953 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] scores = reader.lines().limit(5)
                .mapToInt(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .sum())
                .toArray();

        int maxScore = scores[0];
        int maxIdx = 0;
        for (int i = 1; i < 5; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                maxIdx = i;
            }
        }
        System.out.printf("%d %d%n", maxIdx + 1, maxScore);
    }
}
