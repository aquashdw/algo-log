package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/25372
public class Prob25372 {
    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        reader.lines().limit(tests).forEach(line -> {
            if (line.length() >= 6 && line.length() <= 9) answer.append("yes\n");
            else answer.append("no\n");
        });
        System.out.print(answer);
    }
}
