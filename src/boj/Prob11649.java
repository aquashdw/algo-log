package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/11649
public class Prob11649 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(n).map(line -> {
            char[] reversed = new char[line.length()];
            IntStream.range(0, reversed.length)
                    .forEach(i -> reversed[line.length() - i - 1] = line.charAt(i));
            return new String(reversed);
        })
                .sorted()
                .forEach(line -> answer
                        .append(line)
                        .append(System.lineSeparator())
                );
        System.out.print(answer);
    }
}