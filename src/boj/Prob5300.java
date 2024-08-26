package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5300
public class Prob5300 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i != 0 && i % 6 == 0) answer.append("Go! ");
            answer.append(i + 1).append(' ');
        }
        answer.append("Go!");
        System.out.println(answer);
    }
}
