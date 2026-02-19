package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/9372
public class Prob9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int tests = Integer.parseInt(reader.readLine());
        while (tests-- > 0) {
            int[] info = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int nodes = info[0];
            int edges = info[1];

            List<List<Integer>> adjList = new ArrayList<>(nodes + 1);
            adjList.add(null);
            for (int i = 1; i < nodes + 1; i++) {
                adjList.add(new LinkedList<>());
            }

            reader.lines().limit(edges).forEach(line -> {
                int[] edge = Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            });

            Deque<Integer> stack = new LinkedList<>();
            stack.push(1);
            boolean[] visited = new boolean[nodes + 1];
            visited[0] = true;
            visited[1] = true;
            int count = 0;
            while (!stack.isEmpty()) {
                int now = stack.pop();
                for (int next : adjList.get(now)) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    stack.push(next);
                    count++;
                }
            }
            answer.append(count).append('\n');
        }
        System.out.print(answer);
    }
}
