package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/32025
public class Prob32025 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int min = reader.lines().limit(2).mapToInt(Integer::parseInt).min().orElse(0) * 100;
        System.out.println(min / 2);
    }
}
