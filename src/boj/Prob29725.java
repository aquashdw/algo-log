package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/29725
public class Prob29725 {
    private static final Map<Character, Integer> scores = Map.of(
            'P', 1, 'p', -1,
            'N', 3, 'n', -3,
            'B', 3, 'b', -3,
            'R', 5, 'r', -5,
            'Q', 9, 'q', -9
    );

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines().limit(8).collect(Collectors.joining(""))
                .chars()
                .map(c -> scores.getOrDefault((char) c, 0))
                .sum());
    }
}
