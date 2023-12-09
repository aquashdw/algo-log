package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


// https://www.acmicpc.net/problem/1504
public class Prob1504 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int nodes = Integer.parseInt(info[0]);
        int edges = Integer.parseInt(info[1]);
        int[][] adjMap = new int[nodes + 1][nodes + 1];
        for (int[] row : adjMap) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < edges; i++) {
            int[] edgeInfo = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            adjMap[edgeInfo[0]][edgeInfo[1]] = edgeInfo[2];
            adjMap[edgeInfo[1]][edgeInfo[0]] = edgeInfo[2];
        }

        int[] midGoals = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dist = new int[nodes + 1];
        boolean aFail = false;
        boolean bFail = false;
        dijkstra(1, nodes, dist, adjMap);
        if (dist[midGoals[0]] == Integer.MAX_VALUE) aFail = true;
        if (dist[midGoals[1]] == Integer.MAX_VALUE) bFail = true;
        int startToA = dist[midGoals[0]];
        int startToB = dist[midGoals[1]];

        dijkstra(midGoals[0], nodes, dist, adjMap);
        if (dist[midGoals[1]] == Integer.MAX_VALUE) aFail = true;
        if (dist[nodes] == Integer.MAX_VALUE) bFail = true;
        startToA += dist[midGoals[1]];
        startToB += dist[nodes];
        dijkstra(midGoals[1], nodes, dist, adjMap);
        if (dist[nodes] == Integer.MAX_VALUE) aFail = true;
        if (dist[midGoals[0]] == Integer.MAX_VALUE) bFail = true;
        startToA += dist[nodes];
        startToB += dist[midGoals[0]];

        if (aFail && bFail) System.out.println(-1);
        else System.out.println(Math.min(startToA, startToB));
    }


    public static void dijkstra(int start, int n, int[] dist, int[][] map) {
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.offer(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (visited[now[0]]) continue;
            visited[now[0]] = true;

            for (int i = 1; i < n + 1; i++) {
                // 연결 안됨
                if (map[now[0]][i] == -1) continue;
                int nextCost = map[now[0]][i];
                if (dist[i] > dist[now[0]] + nextCost) {
                    dist[i] = dist[now[0]] + nextCost;
                    queue.offer(new int[]{i, dist[i]});
                }
            }
        }
    }
}
