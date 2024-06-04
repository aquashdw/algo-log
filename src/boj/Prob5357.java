package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5357
public class Prob5357 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests)
                .forEach(line -> answer
                        .append(dedupe(line))
                        .append('\n'));
        System.out.print(answer);
    }

    private static String dedupe(String line) {
        StringBuilder result = new StringBuilder();
        result.append(line.charAt(0));
        char before = line.charAt(0);
        for (int i = 1; i < line.length(); i++) {
            char now = line.charAt(i);
            if (now == before) continue;
            before = now;
            result.append(now);
        }
        return result.toString();
    }
}
