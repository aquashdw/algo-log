package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/5217
public class Prob5217 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).mapToInt(Integer::parseInt)
                .forEach(n -> answer
                        .append(String.format("Pairs for %d: ", n))
                        .append(IntStream.range(1, n + 1)
                                .filter(i -> i < (n + 1) / 2)
                                .mapToObj(i -> String.format("%d %d", i, n - i))
                                .collect(Collectors.joining(", ")))
                        .append('\n'));
        System.out.print(answer);

    }
}
