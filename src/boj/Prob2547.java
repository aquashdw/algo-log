package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2547
public class Prob2547 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int tests = Integer.parseInt(reader.readLine());
        for (int i = 0; i < tests; i++) {
            long n = reader.lines().skip(1).limit(1).mapToLong(Long::parseLong).sum();
            long modSum = reader.lines().limit(n).mapToLong(Long::parseLong)
                    .map(l -> l % n)
                    .sum();
            answer.append(modSum % n == 0 ? "YES\n" : "NO\n");
        }
        System.out.print(answer);
    }
}
