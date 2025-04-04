package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2442
public class Prob2442 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append(" ".repeat(n - i - 1));
            answer.append("*".repeat(2 * i + 1));
            answer.append('\n');
        }
        System.out.print(answer);
    }
}
