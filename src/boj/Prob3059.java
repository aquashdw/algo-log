package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/3059
public class Prob3059 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        int base = 0;
        for (int i = 0; i < 26; i++) {
            base += 'A' + i;
        }
        int sum = base;
        reader.lines().limit(tests)
                .forEach(line -> answer
                        .append(sum - line.chars()
                                .distinct()
                                .sum())
                        .append('\n'));
        System.out.print(answer);
    }

}
