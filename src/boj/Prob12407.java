package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/12407
public class Prob12407 {
    private static int minDiff = Integer.MAX_VALUE;
    private static int[] skills = {};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            minDiff = Integer.MAX_VALUE;
            skills = Arrays.stream(reader.readLine().split(" "))
                    .skip(1)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            dfs(0, new HashSet<>());
            answer.append(String.format("Case #%d: %d%n", test + 1, minDiff));
        }
        System.out.print(answer);
    }

    private static void dfs(int k, Set<Integer> teamA) {
        if (teamA.size() == skills.length / 2) {
            int total = Arrays.stream(skills).sum();
            int aSum = IntStream.range(0, skills.length)
                    .filter(teamA::contains)
                    .map(i -> skills[i])
                    .sum();
            int bSum = total - aSum;
            minDiff = Math.min(minDiff, Math.abs(bSum - aSum));
            return;
        }
        if (k == skills.length) {
            return;
        }

        dfs(k + 1, teamA);
        teamA.add(k);
        dfs(k + 1, teamA);
        teamA.remove(k);
    }
}
