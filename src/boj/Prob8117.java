package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/8117
public class Prob8117 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] edges = reader.lines().takeWhile(line -> !line.equals("0"))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int answer = IntStream.range(0, edges.length - 2)
                .filter(i -> edges[i + 2] < edges[i + 1] + edges[i])
                .findFirst().orElse(-1);

        if (answer == -1) {
            System.out.println("NIE");
            return;
        }
        System.out.printf("%d %d %d%n", edges[answer], edges[answer + 1], edges[answer + 2]);
    }
}
