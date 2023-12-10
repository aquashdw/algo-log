package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1916
public class Prob1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());
        List<List<int[]>> adjList = new ArrayList<>();
        adjList.add(null);

        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            int[] edgeInfo = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            adjList.get(edgeInfo[0]).add(new int[]{edgeInfo[1], edgeInfo[2]});
        }

        String[] sgString = reader.readLine().split(" ");
        int start = Integer.parseInt(sgString[0]);
        int goal = Integer.parseInt(sgString[1]);

        int[] dist = new int[nodes + 1];
        dijkstra(start, nodes, dist, adjList);
        System.out.println(dist[goal]);
    }


    public static void dijkstra(int start, int n, int[] dist, List<List<int[]>> adjList) {
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.offer(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (visited[now[0]]) continue;
            visited[now[0]] = true;

            for (int[] edge : adjList.get(now[0])) {
                if (dist[edge[0]] > dist[now[0]] + edge[1]) {
                    dist[edge[0]] = dist[now[0]] + edge[1];
                    queue.offer(new int[]{edge[0], dist[edge[0]]});
                }
            }

        }
    }
}
