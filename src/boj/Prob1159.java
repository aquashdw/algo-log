package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/1159
public class Prob1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int names = Integer.parseInt(reader.readLine());
        int[] counts = new int[26];
        int maxCount = reader.lines().limit(names)
                .mapToInt(line -> line.charAt(0))
                .reduce(0, (maxInt, c) -> {
                    counts[c - 'a']++;
                    return Math.max(counts[c - 'a'], maxInt);
                });
        if (maxCount < 5) {
            System.out.println("PREDAJA");
            return;
        }

        System.out.println(IntStream.range(0, 26)
                .filter(i -> counts[i] > 4)
                .mapToObj(i -> String.valueOf((char) ('a' + i)))
                .collect(Collectors.joining()));
    }
}
