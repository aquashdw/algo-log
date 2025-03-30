package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2445
public class Prob2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            answer.append("*".repeat(i + 1));
            answer.append(" ".repeat((n - i - 1) * 2));
            answer.append("*".repeat(i + 1));
            answer.append('\n');
        }
        answer.append("*".repeat(2 * n)).append('\n');
        for (int i = 0; i < n - 1; i++) {
            answer.append("*".repeat(n - i - 1));
            answer.append(" ".repeat((i + 1) * 2));
            answer.append("*".repeat(n - i - 1));
            answer.append('\n');
        }
        System.out.print(answer);
    }
}
