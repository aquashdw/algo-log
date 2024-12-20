package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/3264
public class Prob3264 {
    private static List<Map<Integer, Integer>> adjList;
    private static boolean[] visited;
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ns = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int n = ns[0];
        int start = ns[1];
        visited = new boolean[n + 1];
        adjList = new ArrayList<>(n + 1);
        adjList.add(null);
        for (int i = 0; i < n; i++) {
            adjList.add(new HashMap<>());
        }
        int total = reader.lines().limit(n - 1).mapToInt(line -> {
            int[] edge = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            adjList.get(edge[0]).put(edge[1], edge[2]);
            adjList.get(edge[1]).put(edge[0], edge[2]);
            return edge[2];
        }).sum();
        visited[start] = true;
        dfs(start, 0);
        System.out.println(total * 2 - max);
    }

    private static void dfs(int now, int dist) {
        max = Math.max(dist, max);
        for (Map.Entry<Integer, Integer> node : adjList.get(now).entrySet()) {
            int next = node.getKey();
            int cost = node.getValue();
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, dist + cost);
            }
        }
    }
}
