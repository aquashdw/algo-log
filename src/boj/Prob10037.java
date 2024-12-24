package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/10037
public class Prob10037 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        List<Set<Integer>> adjList = new ArrayList<>();
        adjList.add(null);
        for (int i = 0; i < nm[0] + 1; i++) {
            adjList.add(new HashSet<>());
        }

        reader.lines().limit(nm[1]).forEach(line -> {
            int[] edge = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        });

        int[] visited = new int[nm[0] + 1];
        int maxes = 0;
        Queue<Integer> toVisit = new LinkedList<>();
        boolean failed = false;
        int nextStart = 0;
        while (!failed && (nextStart = IntStream.range(nextStart + 1, nm[0] + 1).filter(i -> visited[i] == 0).findFirst().orElse(-1)) != -1) {
            visited[nextStart] = 1;
            toVisit.add(nextStart);
            int[] values = {1, 0};
            while (!toVisit.isEmpty() && !failed) {
                int now = toVisit.poll();
                int nextVal = -visited[now];
                for (int next : adjList.get(now)) {
                    if (visited[next] == 0) {
                        visited[next] = nextVal;
                        toVisit.offer(next);
                        values[nextVal > 0 ? 0 : 1]++;
                    } else if (visited[next] != nextVal) {
                        failed = true;
                    }
                }
            }
            maxes += Math.max(values[0], values[1]);
        }
        System.out.println(failed ? -1 : Math.max(maxes, nm[0] - maxes));
    }
}
