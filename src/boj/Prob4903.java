package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/4903
public class Prob4903 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines().takeWhile(line -> !line.equals("-1 -1"))
                .map(line -> {
                    int[] scores = Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt).toArray();
                    if (scores[0] == 1 || scores[1] == 1)
                        return String.format("%d+%d=%d", scores[0], scores[1], scores[0] + scores[1]);
                    else return String.format("%d+%d!=%d", scores[0], scores[1], scores[0] + scores[1]);
                })
                .collect(Collectors.joining("\n")));
    }
}
