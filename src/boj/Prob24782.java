package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/24782
public class Prob24782 {
    private static int max = 0;
    private static List<Set<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        adjList = new ArrayList<>(n);
        IntStream.range(0, n).forEach(i -> adjList.add(new HashSet<>()));
        for (int i = 0; i < n; i++) {
            int start = i;
            Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .forEach(end -> {
                        adjList.get(start).add(end);
                        adjList.get(end).add(start);
                    });
        }

        for (int i = 0; i < n; i++) {
            boolean[] grouped = new boolean[n];
            Arrays.fill(grouped, 0, i + 1, true);
            Set<Integer> selected = new HashSet<>();
            selected.add(i);
            dfs(i, selected, grouped);
        }
        System.out.println(max);
    }

    private static void dfs(int now, Set<Integer> selected, boolean[] grouped) {
        boolean finish = true;
        for (int next : adjList.get(now)) {
            if (grouped[next] || next < now) continue;
            if (!adjList.get(next).containsAll(selected)) continue;
            grouped[next] = true;
            selected.add(next);
            finish = false;
            dfs(next, selected, grouped);
            grouped[next] = false;
            selected.remove(next);
        }
        if (finish) {
            max = Math.max(max, selected.size());
        }
    }
}
