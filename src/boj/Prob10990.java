package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10990
public class Prob10990 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            answer.append(" ".repeat(Math.max(0, n - i)));
            for (int j = 0; j < 2 * i - 1; j++) {
                if (j == 0 || j == 2 * i - 2) answer.append('*');
                else answer.append(' ');
            }
            answer.append('\n');
        }

        System.out.print(answer);
    }
}