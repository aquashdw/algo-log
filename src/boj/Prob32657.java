package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/32657
public class Prob32657 {
    private static int[][] adjList;
    private static boolean[][] dp;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        adjList = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            int[] points = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            adjList[i][0] = points[0];
            adjList[i][1] = points[1];
        }

        dp = new boolean[100][n + 1];
        visited = new boolean[100][n + 1];
        for (int i = 1; i < n + 1; i++) {
            int[] next = adjList[i];
            dp[1][i] = !(next[0] == 1 || next[1] == 1);
            visited[1][i] = true;
        }
        for (int i = 10; i < 100; i++) {
            if (dfs(i, 1)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    private static boolean dfs(int turns, int player) {
        if (visited[turns][player]) return dp[turns][player];
        visited[turns][player] = true;
        int[] next = adjList[player];
        if (player == 1) {
            dp[turns][player] = dfs(turns - 1, next[0]) || dfs(turns - 1, next[1]);
        } else {
            dp[turns][player] = dfs(turns - 1, next[0]) && dfs(turns - 1, next[1]);
        }
        return dp[turns][player];
    }
}
