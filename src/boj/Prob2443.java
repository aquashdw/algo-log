package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/2443
public class Prob2443 {
    private static final Set<Integer> emptySet = Collections.emptySet();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        IntStream.range(0, n).forEach(i -> {
            answer.append(" ".repeat(i));
            answer.append("*".repeat(2 * (n - i) - 1));
            answer.append('\n');
        });
        System.out.print(answer);
    }
}
