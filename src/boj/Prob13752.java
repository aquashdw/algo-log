package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/13752
public class Prob13752 {
    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        reader.lines().limit(n)
                .mapToInt(Integer::parseInt)
                .mapToObj(i -> String.format("%s%n", "=".repeat(i)))
                .forEach(answer::append);
        System.out.print(answer);
    }
}
