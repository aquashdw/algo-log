package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/16021
public class Prob16021 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pageCount = Integer.parseInt(reader.readLine());
        int[][] pages = new int[pageCount + 1][];
        Set<Integer> endings = new HashSet<>();
        for (int i = 1; i < pageCount + 1; i++) {
            pages[i] = Arrays.stream(reader.readLine().split(" "))
                    .skip(1)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (pages[i].length == 0) endings.add(i);
        }
        Boolean[] visited = new Boolean[pageCount + 1];
        Arrays.fill(visited, false);
        visited[1] = true;
        int minEnd = Integer.MAX_VALUE;
        Queue<int[]> toVisit = new LinkedList<>();
        toVisit.add(new int[]{1, 1});
        while (!toVisit.isEmpty()) {
            int[] now = toVisit.poll();
            for (int next : pages[now[0]]) {
                if (visited[next]) continue;
                visited[next] = true;
                if (endings.contains(next)) {
                    minEnd = Math.min(minEnd, now[1] + 1);
                    continue;
                }
                toVisit.add(new int[]{next, now[1] + 1});
            }
        }
        boolean done = Arrays.stream(visited).skip(1).allMatch(b -> b);
        System.out.printf("%c%n%d%n", done ? 'Y' : 'N', minEnd);
    }
}
