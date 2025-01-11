package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/27009
public class Prob27009 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        int[][] adjMat = new int[n + 1][n + 1];
        for (int[] row : adjMat) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        List<Set<Integer>> adjList = new ArrayList<>(n + 1);
        adjList.add(null);
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
        }

        for (int i = 0; i < m; i++) {
            int[] edge = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            adjMat[edge[0]][edge[1]] = Math.min(adjMat[edge[0]][edge[1]], edge[2]);
            adjMat[edge[1]][edge[0]] = Math.min(adjMat[edge[1]][edge[0]], edge[2]);
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        int[] dist = new int[n + 1];
        int start = 1;
        Queue<int[]> toVisit = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int next : adjList.get(start)) {
            toVisit.offer(new int[]{next, adjMat[start][next]});
        }

        while (!toVisit.isEmpty()) {
            int[] now = toVisit.poll();
            if (visited[now[0]]) continue;
            visited[now[0]] = true;
            dist[now[0]] = now[1];

            for (int next : adjList.get(now[0])) {
                if (visited[next]) continue;
                toVisit.offer(new int[]{next, adjMat[now[0]][next]});
            }
        }

        System.out.println(Arrays.stream(dist).max().orElse(0));
    }
}
