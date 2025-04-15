package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/1032
public class Prob1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<String> results = reader.lines().limit(n)
                .collect(Collectors.toList());
        int strLength = results.get(0).length();
        boolean[] same = new boolean[strLength];
        Arrays.fill(same, true);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < strLength; j++) {
                if (!same[j]) continue;
                same[j] = results.get(i - 1).charAt(j) == results.get(i).charAt(j);
            }
        }

        System.out.println(IntStream.range(0, strLength)
                .mapToObj(i -> same[i] ? String.valueOf(results.get(0).charAt(i)) : "?")
                .collect(Collectors.joining("")));
    }
}
