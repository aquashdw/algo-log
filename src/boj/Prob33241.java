package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// https://www.acmicpc.net/problem/33241
public class Prob33241 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int matches = n * (n - 1) / 2;
        Map<String, Integer> scores = new HashMap<>();
        reader.lines().limit(matches).forEach(line -> {
            String[] tokens = line.split(" ");
            scores.putIfAbsent(tokens[0], 0);
            scores.putIfAbsent(tokens[1], 0);
            int[] matchScore = new int[2];
            matchScore[0] = Integer.parseInt(tokens[2]);
            matchScore[1] = Integer.parseInt(tokens[3]);
            if (matchScore[0] > matchScore[1]) {
                scores.put(tokens[0], scores.get(tokens[0]) + 3);
            } else if (matchScore[0] < matchScore[1]) {
                scores.put(tokens[1], scores.get(tokens[1]) + 3);
            } else {
                scores.put(tokens[0], scores.get(tokens[0]) + 1);
                scores.put(tokens[1], scores.get(tokens[1]) + 1);
            }
        });

        StringBuilder answer = new StringBuilder();
        scores.entrySet().stream()
                .sorted((o1, o2) -> {
                    if (Objects.equals(o1.getValue(), o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return -Integer.compare(o1.getValue(), o2.getValue());
                })
                .limit(5)
                .forEach(entry -> {
                    answer.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
                });

        System.out.print(answer);
    }
}
