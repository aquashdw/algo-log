package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/21316
public class Prob21316 {
    private static final int[] spicaDist = {1, 3, 3, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> adjList = new ArrayList<>(13);
        for (int i = 0; i < 13; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] inDegrees = new int[13];
        reader.lines().limit(12).forEach(line -> {
            int[] edge = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            inDegrees[edge[0]]++;
            inDegrees[edge[1]]++;
        });

        int[] candidates = IntStream.range(1, 13).filter(i -> inDegrees[i] == 3).toArray();
        int[] leaves = IntStream.range(1, 13).filter(i -> inDegrees[i] == 1).toArray();

        int spica = -1;
        for (int candidate : candidates) {
            int[] visited = new int[13];
            Arrays.fill(visited, -1);
            visited[candidate] = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{candidate, 0});
            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                int now = node[0];
                int dist = node[1];
                for (int next : adjList.get(now)) {
                    if (visited[next] != -1) continue;
                    visited[next] = dist + 1;
                    queue.offer(new int[]{next, visited[next]});
                }
            }
            int[] distLeaves = Arrays.stream(leaves).map(leaf -> visited[leaf]).sorted().toArray();
            if (IntStream.range(0, 4).allMatch(i -> distLeaves[i] == spicaDist[i])) {
                spica = candidate;
                break;
            }
        }
        System.out.println(spica);
    }
}
