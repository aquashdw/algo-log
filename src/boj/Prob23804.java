package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/23804
public class Prob23804 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append("@".repeat(n * 5)).append('\n');
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                answer.append("@".repeat(n)).append('\n');
            }
        }
        for (int i = 0; i < n; i++) {
            answer.append("@".repeat(n * 5)).append('\n');
        }
        System.out.print(answer);
    }
}
