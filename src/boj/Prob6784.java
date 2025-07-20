package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/6784
public class Prob6784 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int problems = Integer.parseInt(reader.readLine());
        int[] responses = reader.lines().limit(problems)
                .mapToInt(line -> line.charAt(0) - 'A')
                .toArray();
        int[] answers = reader.lines().limit(problems)
                .mapToInt(line -> line.charAt(0) - 'A')
                .toArray();
        System.out.println(IntStream.range(0, problems)
                .filter(i -> responses[i] == answers[i])
                .count());
    }
}
