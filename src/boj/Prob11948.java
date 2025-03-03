package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11948
public class Prob11948 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int score = reader.lines().limit(4)
                .mapToInt(Integer::parseInt)
                .sorted()
                .skip(1)
                .sum();
        score += reader.lines().limit(2)
                .mapToInt(Integer::parseInt)
                .max()
                .orElseThrow();
        System.out.println(score);
    }
}
