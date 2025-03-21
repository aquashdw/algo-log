package boj.onhold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/4129
public class Prob4129 {
    private static final Set<Integer> emptySet = Collections.emptySet();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Map<Integer, Set<Integer>> megaPairs = new HashMap<>();
        reader.lines().limit(input[0]).forEach(line -> {
            int[] mega = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            if (mega[0] < 101)
                megaPairs.computeIfAbsent(mega[0], k -> new HashSet<>()).add(mega[1]);
            if (mega[1] < 101)
                megaPairs.computeIfAbsent(mega[1], k -> new HashSet<>()).add(mega[0]);
        });

        StringBuilder answer = new StringBuilder();
        reader.lines().limit(input[1]).mapToInt(Integer::parseInt)
                .forEach(sum -> {
                    long count = IntStream.range(0, sum + 1).mapToLong(i -> megaPairs.getOrDefault(i, emptySet).stream()
                            .filter(opI -> megaPairs.getOrDefault(sum - i, emptySet).contains(opI))
                            .count()).sum();
                    answer.append(count).append('\n');
                });
        System.out.print(answer);
    }
}
