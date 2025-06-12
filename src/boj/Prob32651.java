package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/32651
public class Prob32651 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines().limit(1)
                .mapToInt(Integer::parseInt)
                .allMatch(i -> i <= 100000 && i % 2024 == 0) ? "Yes" : "No");
    }
}
