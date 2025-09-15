package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/21941
public class Prob21941 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String target = reader.readLine();
        int words = Integer.parseInt(reader.readLine());
        Map<Integer, Set<String>> startIndices = new HashMap<>();
        Map<String, Integer> scores = new HashMap<>();
        for (int i = 0; i < words; i++) {
            String[] wordScore = reader.readLine().split(" ");
            String word = wordScore[0];
            int score = Integer.parseInt(wordScore[1]);
            scores.put(word, score);
            int start = 0;
            while ((start = target.indexOf(word, start)) >= 0) {
                startIndices.computeIfAbsent(start, k -> new HashSet<>()).add(word);
                start++;
            }
        }

        int[] dp = IntStream.range(0, target.length() + 1).toArray();
        for (int i = 1; i < target.length() + 1; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            for (String word : startIndices.getOrDefault(i - 1, Collections.emptySet())) {
                dp[i + word.length() - 1] = Math.max(dp[i + word.length() - 1], dp[i - 1] + scores.get(word));
            }
        }
        System.out.println(dp[target.length()]);
    }
}
