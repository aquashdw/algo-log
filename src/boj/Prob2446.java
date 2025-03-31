package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2446
public class Prob2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int stars = 2 * (n - i) - 1;

            answer.append(" ".repeat(i)).append("*".repeat(stars)).append('\n');
        }
        for (int i = n - 2; i > -1; i--) {
            int stars = 2 * (n - i) - 1;
            answer.append(" ".repeat(i)).append("*".repeat(stars)).append('\n');
        }
        System.out.print(answer);
    }
}
