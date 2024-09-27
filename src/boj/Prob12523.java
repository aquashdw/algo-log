package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/12523
public class Prob12523 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            answer.append(String.format("Case #%d:\n", i + 1));
            int n = Integer.parseInt(reader.readLine());
            int[] input = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            List<List<Integer>> adjList = new ArrayList<>(n + 1);
            adjList.add(null);
            IntStream.range(1, n + 1).forEach(idx -> {
                List<Integer> followers = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    int follows = input[j];
                    if (follows == idx) followers.add(j + 1);
                }
                adjList.add(followers);
            });

            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                int day = j + 1;
                for (int follower: adjList.get(day)) {
                    visited[follower] = true;
                    queue.add(follower);
                }
                visited[day] = true;
                while (!queue.isEmpty()) {
                    int now = queue.poll();
                    for (int next: adjList.get(now)) {
                        if (visited[next]) continue;
                        visited[next] = true;
                        queue.add(next);
                    }
                }
                int count = 0;
                for (boolean visit: visited) {
                    if (visit) count++;
                }
                answer.append(count).append('\n');
                Arrays.fill(visited, false);
            }
        }
        System.out.print(answer);
    }
}

