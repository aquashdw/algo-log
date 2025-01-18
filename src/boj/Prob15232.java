package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/15232
public class Prob15232 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] rc = reader.lines().limit(2)
                .mapToInt(Integer::parseInt).toArray();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < rc[0]; i++) {
            answer.append("*".repeat(rc[1])).append('\n');
        }
        System.out.print(answer);
    }
}
