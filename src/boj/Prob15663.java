package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/15663
public class Prob15663 {
    private static final StringBuilder answer = new StringBuilder();
    private static boolean[] visited;
    private static int[] selected;
    private static int[] nums;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = nm[0];
        m = nm[1];
        nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        visited = new boolean[n];
        selected = new int[m];
        dfs(0);
        System.out.print(answer);
    }

    private static void dfs(int level) {
        if (level == m) {
            answer.append(Arrays.stream(selected)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
            answer.append('\n');
            return;
        }
        int lastUsed = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && lastUsed != nums[i]) {
                lastUsed = nums[i];
                selected[level] = nums[i];
                visited[i] = true;
                dfs(level + 1);
                visited[i] = false;
            }
        }
    }
}
