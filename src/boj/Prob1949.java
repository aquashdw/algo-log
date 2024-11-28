package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/1949
public class Prob1949 {
    private static int[][] dp;
    private static boolean[] visited;
    private static int[] population;
    private static List<List<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(reader.readLine());
        dp = new int[nodes + 1][2];
        visited = new boolean[nodes + 1];
        population = new int[nodes + 1];
        int node = 1;
        for (int pop: Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
            population[node] = pop;
            node++;
        }

        adjList = new ArrayList<>(nodes + 1);
        adjList.add(null);
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        reader.lines().limit(nodes - 1).forEach(line -> {
            int[] edge = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        });

        visited[1] = true;
        dfs(1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    private static void dfs(int now) {
        dp[now][0] = 0;
        dp[now][1] = population[now];

        for (int next: adjList.get(now)) {
            if (visited[next]) continue;
            visited[next] = true;
            dfs(next);
            dp[now][0] += Math.max(dp[next][0], dp[next][1]);
            dp[now][1] += dp[next][0];
        }
    }
}
