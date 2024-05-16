package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1260
public class Prob1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nmv = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(null);
        for (int i = 0; i < nmv[0]; i++) {
            adjList.add(new ArrayList<>());
        }

        reader.lines().limit(nmv[1])
                .forEach(line -> {
                    int[] edge = Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    adjList.get(edge[0]).add(edge[1]);
                    adjList.get(edge[1]).add(edge[0]);
                });

        StringBuilder answer = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[nmv[0] + 1];
        stack.push(nmv[2]);

        while (!stack.isEmpty()) {
            int now = stack.pop();
            if (visited[now]) continue;
            visited[now] = true;
            answer.append(now).append(' ');
            adjList.get(now).stream()
                    .filter(next -> !visited[next])
                    .sorted(Comparator.reverseOrder())
                    .forEach(stack::push);
        }
        answer.append('\n');

        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(visited, false);
        queue.offer(nmv[2]);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (visited[now]) continue;
            visited[now] = true;
            answer.append(now).append(' ');
            adjList.get(now).stream()
                    .filter(next -> !visited[next])
                    .sorted()
                    .forEach(queue::offer);
        }

        System.out.println(answer);
    }
}

