package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

// https://www.acmicpc.net/problem/8913
public class Prob8913 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> {
            List<Integer> continuous = new LinkedList<>();
            char now = line.charAt(0);
            int count = 1;
            for (int i = 1; i < line.length(); i++) {
                if (line.charAt(i) == now) {
                    count++;
                } else {
                    continuous.add(count);
                    now = line.charAt(i);
                    count = 1;
                }
            }
            continuous.add(count);
            int[] counts = continuous.stream().mapToInt(i -> i).toArray();
            if (dfs(counts)) answer.append(1).append('\n');
            else answer.append(0).append('\n');
        });
        System.out.print(answer);
    }

    private static boolean dfs(int[] counts) {
        if (counts.length == 1) {
            return counts[0] > 1;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 1) continue;
            int newCount = 0;
            int compress = 0;
            if (i > 0) {
                newCount += counts[i - 1];
                compress++;
            }
            if (i < counts.length - 1) {
                newCount += counts[i + 1];
                compress++;
            }
            int[] newCounts = new int[counts.length - compress];
            int idx = 0;
            for (int j = 0; j < i - 1; j++) {
                newCounts[idx] = counts[j];
                idx++;
            }
            newCounts[idx] = newCount;
            idx++;
            for (int j = i + 2; j < counts.length; j++) {
                newCounts[idx] = counts[j];
                idx++;
            }
            if (dfs(newCounts)) return true;
        }
        return false;
    }
}
