package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/9306
public class Prob9306 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append("Case ").append(i + 1).append(": ");
            String first = reader.readLine();
            String last = reader.readLine();
            answer.append(last).append(", ").append(first).append('\n');
        }
        System.out.print(answer);
    }

}
