package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2523
public class Prob2523 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 2 * n - 1; i++) {
            answer.append("*".repeat(n - Math.abs(n - i - 1)));
            answer.append('\n');
        }
        System.out.print(answer);
    }
}
