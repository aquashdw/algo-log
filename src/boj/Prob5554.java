package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5554
public class Prob5554 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int secs = reader.lines().limit(4)
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.printf("%d%n%d%n", secs / 60, secs % 60);
    }
}
