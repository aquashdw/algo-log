package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/2644
public class Prob2644 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<List<Integer>> adjList = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] path = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int start = path[0];
        int end = path[1];

        int edges = Integer.parseInt(reader.readLine());
        reader.lines().limit(edges).forEach(line -> {
            int[] edge = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        });

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        boolean[] visited = new boolean[n + 1];
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == end) {
                min = now[1];
                break;
            }
            adjList.get(now[0]).forEach(adj -> {
                if (visited[adj]) return;
                visited[adj] = true;
                queue.offer(new int[]{adj, now[1] + 1});
            });
        }

        System.out.println(min != Integer.MAX_VALUE ? min : -1);
    }
}
