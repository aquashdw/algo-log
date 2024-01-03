package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/1766
public class Prob1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] probInfo = reader.readLine().split(" ");
        int probCount = Integer.parseInt(probInfo[0]);
        int edges = Integer.parseInt(probInfo[1]);

        List<Set<Integer>> adjList = new ArrayList<>();
        adjList.add(null);
        for (int i = 0; i < probCount; i++) {
            adjList.add(new HashSet<>());
        }

        int[] inDegrees = new int[probCount + 1];
        PriorityQueue<Integer> next = new PriorityQueue<>();
        for (int i = 0; i < edges; i++) {
            int[] edge = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            adjList.get(edge[0]).add(edge[1]);
            inDegrees[edge[1]]++;
        }

        for (int i = 1; i < probCount + 1; i++) {
            if (inDegrees[i] == 0) next.offer(i);
        }

        List<Integer> result = new ArrayList<>(probCount);
        while (!next.isEmpty()) {
            int now = next.poll();
            result.add(now);
            Set<Integer> adjNodes = adjList.get(now);
            for (int node: adjNodes) {
                inDegrees[node]--;
                if (inDegrees[node] == 0) {
                    next.offer(node);
                }
            }
        }

        System.out.println(result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
