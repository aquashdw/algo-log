package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/23811
public class Prob23811 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                answer.append("@".repeat(n * (i % 2 == 0 ? 5 : 1))).append('\n');
            }
        }
        System.out.print(answer);
    }
}
