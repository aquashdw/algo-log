package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/23959
public class Prob23959 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int testCase = 1; testCase < tests + 1; testCase++) {
            int n = Integer.parseInt(reader.readLine());
            List<List<Integer>> adjList = new ArrayList<>(n + 1);
            adjList.add(null);
            for (int j = 0; j < n; j++) {
                adjList.add(new ArrayList<>());
            }
            int[] inDegrees = new int[n + 1];
            reader.lines().limit(n).forEach(line -> {
                int[] edge = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
                inDegrees[edge[0]]++;
                inDegrees[edge[1]]++;
            });

            Queue<Integer> check = new LinkedList<>();
            IntStream.rangeClosed(1, n)
                    .filter(i -> inDegrees[i] == 1)
                    .forEach(check::add);

            while (!check.isEmpty()) {
                int now = check.poll();
                inDegrees[now]--;
                for (int adj : adjList.get(now)) {
                    inDegrees[adj]--;
                    if (inDegrees[adj] == 1) {
                        check.add(adj);
                    }
                }
            }

            Queue<int[]> toVisit = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            int[] dist = new int[n + 1];
            IntStream.rangeClosed(1, n)
                    .filter(i -> inDegrees[i] > 0)
                    .forEach(i -> {
                        visited[i] = true;
                        toVisit.add(new int[]{i, 0});
                    });
            while (!toVisit.isEmpty()) {
                int[] now = toVisit.poll();
                dist[now[0]] = now[1];
                for (int adj : adjList.get(now[0])) {
                    if (visited[adj]) continue;
                    visited[adj] = true;
                    toVisit.add(new int[]{adj, now[1] + 1});
                }
            }

            answer.append("Case #").append(testCase).append(": ")
                    .append(IntStream.rangeClosed(1, n)
                            .mapToObj(i -> String.valueOf(dist[i]))
                            .collect(Collectors.joining(" ")))
                    .append('\n');
        }
        System.out.print(answer);
    }
}
/*
1
13
1 2
1 5
2 3
2 4
2 6
2 12
3 11
4 8
5 7
5 10
7 13
8 9
10 12

3
5
1 2
2 3
2 4
3 4
3 5
3
1 2
1 3
2 3
13
1 2
1 5
2 3
2 4
2 6
2 12
3 11
4 8
5 7
5 10
7 13
8 9
10 12

 */