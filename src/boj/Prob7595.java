package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/7595
public class Prob7595 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        StringBuilder answer = new StringBuilder();
        while ((n = Integer.parseInt(reader.readLine())) != 0) {
            for (int i = 0; i < n; i++) {
                answer.append("*".repeat(i + 1)).append('\n');
            }
        }
        System.out.print(answer);
    }
}
