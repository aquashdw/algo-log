package boj.onhold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/23087
public class Prob23087 {
    private static int[] swaps;
    private static long[] dists;
    private static List<List<int[]>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nmxy = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = nmxy[0];
        int m = nmxy[1];
        int start = nmxy[2];
        int goal = nmxy[3];
        adjList = new ArrayList<>(n + 1);
        adjList.add(null);
        for (int i = 0; i < n; i++) {
            adjList.add(new LinkedList<>());
        }
        reader.lines().limit(m).forEach(line -> {
            int[] edge = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            adjList.get(edge[0]).add(new int[]{edge[1], edge[2]});
        });

        dists = new long[n + 1];
        Arrays.fill(dists, 20_000_000_001L);
        Queue<long[]> distQueue = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        distQueue.offer(new long[]{start, 0});
        dists[start] = 0;
        for (int i = 0; i < n; i++) {
            long[] minNode = null;
            while (!distQueue.isEmpty()) {
                long[] polled = distQueue.poll();
                if (dists[(int) polled[0]] < polled[1]) continue;
                minNode = polled;
                break;
            }

            if (minNode == null) break;
            int now = (int) minNode[0];

            for (int[] edge : adjList.get(now)) {
                int next = edge[0];
                if (dists[next] <= dists[now] + edge[1]) continue;
                dists[next] = dists[now] + edge[1];
                distQueue.offer(new long[]{next, edge[1]});
            }
        }

        if (dists[goal] == 20_000_000_001L) {
            System.out.println(-1);
            return;
        }

        Queue<Integer> swapQueue = new LinkedList<>();
        swapQueue.offer(start);
        swaps = new int[n + 1];
        Arrays.fill(swaps, n + 1);
        swaps[start] = 0;
        while (!swapQueue.isEmpty()) {
            int now = swapQueue.poll();
            for (int[] edge : adjList.get(now)) {
                int next = edge[0];
                if (dists[next] != dists[now] + edge[1]) continue;
                if (swaps[next] != n + 1) continue;
                swaps[next] = swaps[now] + 1;
                swapQueue.offer(next);
            }
        }

        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        dp[goal] = 1;
        long count = dfs(start, dp);
        System.out.printf("%d%n%d%n%d%n", dists[goal], swaps[goal], count);
    }

    private static long dfs(int now, long[] dp) {
        if (dp[now] != -1) return dp[now];
        long count = 0;
        for (int[] edge : adjList.get(now)) {
            int next = edge[0];
            if (dists[next] == dists[now] + edge[1] && swaps[next] == swaps[now] + 1) count += dfs(next, dp);
        }
        dp[now] = count % 1_000_000_009;
        return dp[now];
    }
}
