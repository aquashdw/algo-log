package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/11724
public class Prob11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<List<Integer>> adjList = new ArrayList<>(nm[0] + 1);
        for (int i = 0; i < nm[0] + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        reader.lines().limit(nm[1]).map(line -> Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray())
                .forEach(edge -> {
                    adjList.get(edge[0]).add(edge[1]);
                    adjList.get(edge[1]).add(edge[0]);
                });

        boolean[] visited = new boolean[nm[0] + 1];
        visited[0] = true;

        int components = 0;
        int start;
        while ((start = getNextStart(visited)) != -1) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            visited[start] = true;
            components++;
            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (int next : adjList.get(now)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        System.out.println(components);
    }

    private static int getNextStart(boolean[] visited) {
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) return i;
        }
        return -1;
    }
}
