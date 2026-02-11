package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/3578
public class Prob3578 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n == 0) {
            System.out.println(1);
            return;
        }
        if (n == 1) {
            System.out.println(0);
            return;
        }
        StringBuilder answer = new StringBuilder();
        if (n % 2 == 1) {
            answer.append(4);
        }
        answer.append("8".repeat(n / 2));
        System.out.println(answer);
    }
}
