package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/2606
public class Prob2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(reader.readLine());
        List<List<Integer>> adjList = new ArrayList<>();
        IntStream.rangeClosed(0, nodes)
                .forEach(ignored -> adjList.add(new ArrayList<>()));
        reader.lines()
                .skip(1)
                .forEach(line -> {
            int[] edge = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        });

        Queue<Integer> toVisit = new LinkedList<>();
        toVisit.add(1);
        Boolean[] visited = new Boolean[nodes + 1];
        Arrays.fill(visited, false);
        visited[1] = true;
        while (!toVisit.isEmpty()) {
            int now = toVisit.poll();
            for (int next: adjList.get(now)) {
                if (visited[next]) continue;
                visited[next] = true;
                toVisit.add(next);
            }
        }
        System.out.println(Arrays.stream(visited)
                .filter(bool -> bool)
                .count() - 1);
    }
}
