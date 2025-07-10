package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/1969
public class Prob1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int n = info[0];
        int length = info[1];

        String[] dnaArr = reader.lines().limit(n).toArray(String[]::new);
        StringBuilder answer = new StringBuilder();
        int distanceSum = 0;
        for (int i = 0; i < length; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                map.compute(dnaArr[j].charAt(i), (key, value) -> value == null ? 1 : value + 1);
            }

            int maxVal = map.values().stream()
                    .mapToInt(Integer::intValue)
                    .max()
                    .orElseThrow();

            answer.append(map.entrySet().stream()
                    .filter(entry -> entry.getValue() == maxVal)
                    .map(Map.Entry::getKey)
                    .sorted()
                    .findFirst()
                    .orElseThrow());

            distanceSum += n - maxVal;
        }
        answer.append('\n').append(distanceSum);
        System.out.println(answer);
    }
}
