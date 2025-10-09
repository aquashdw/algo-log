package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/24480
public class Prob24480 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nmr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int n = nmr[0];
        int m = nmr[1];
        int start = nmr[2];
        int[] visited = new int[n + 1];
        List<Queue<Integer>> adjList = new ArrayList<>(n + 1);
        adjList.add(null);
        for (int i = 0; i < n; i++) {
            adjList.add(new PriorityQueue<>());
        }
        for (int i = 0; i < m; i++) {
            int[] edge = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            adjList.get(edge[0]).offer(edge[1]);
            adjList.get(edge[1]).offer(edge[0]);
        }
        Stack<Integer> toVisit = new Stack<>();
        toVisit.push(start);
        int seq = 0;
        while (!toVisit.isEmpty()) {
            int now = toVisit.pop();
            if (visited[now] != 0) continue;
            seq++;
            visited[now] = seq;
            Queue<Integer> pool = new PriorityQueue<>();
            while (!adjList.get(now).isEmpty()) {
                int next = adjList.get(now).poll();
                if (visited[next] != 0) continue;
                pool.offer(next);
                toVisit.push(next);
            }
            adjList.set(now, pool);
        }
        StringBuilder answer = new StringBuilder();
        Arrays.stream(visited, 1, n + 1).forEach(i -> answer.append(i).append('\n'));
        System.out.print(answer);
    }
}
