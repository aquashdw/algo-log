package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2805
public class Prob2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int required = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray()[1];

        long[] trees = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        long start = 0;
        long end = Arrays.stream(trees).max().orElseThrow();

        while (start + 1 < end) {
            long mid = (start + end) / 2;
            long total = Arrays.stream(trees)
                    .map(i -> i > mid ? i - mid : 0)
                    .sum();

            if (total >= required) {
                start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }
}

