package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/9461
public class Prob9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        int[] cases = reader.lines().limit(tests)
                .mapToInt(Integer::parseInt)
                .toArray();
        int max = Arrays.stream(cases).max().orElseThrow();

        List<Long> padovan = new ArrayList<>(max);
        padovan.addAll(List.of(1L, 1L, 1L, 2L, 2L, 3L, 4L, 5L, 7L, 9L));
        for (int i = 10; i < max; i++) {
            padovan.add(padovan.get(i - 5) + padovan.get(i - 1));
        }

        StringBuilder answer = new StringBuilder();
        Arrays.stream(cases)
                .forEach(i -> answer.append(padovan.get(i - 1)).append('\n'));
        System.out.print(answer);
    }
}
