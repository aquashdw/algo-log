package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2460
public class Prob2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] diffs = reader.lines().limit(10)
                .mapToInt(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .reduce(-1, (prev, next) -> {
                            if (prev < 0) return next;
                            return -prev + next;
                        }))
                .toArray();
        for (int i = 1; i < 10; i++) {
            diffs[i] += diffs[i - 1];
        }
        Arrays.stream(diffs).max().ifPresent(System.out::println);
    }
}
