package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/27978
public class Prob27978 {
    private static final int[][] cost = {
            {-1, -1}, {-1, 0},
            {0, -1},
            {1, -1}, {1, 0},
    };
    private static final int[][] free = {
            {-1, 1},
            {0, 1},
            {1, 1},
    };
    private static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        size = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        char[][] map = new char[size[0]][];
        int[] start = {-1, -1};
        int[] goal = {-1, -1};
        for (int i = 0; i < size[0]; i++) {
            String line = reader.readLine();
            if (line.contains("K")) {
                start[0] = i;
                start[1] = line.indexOf("K");
            }
            if (line.contains("*")) {
                goal[0] = i;
                goal[1] = line.indexOf("*");
            }
            map[i] = line.toCharArray();
        }

        int[][] dists = new int[size[0]][size[1]];
        boolean[][] visited = new boolean[size[0]][size[1]];
        Arrays.stream(dists).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
        Queue<int[]> toVisit = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        toVisit.add(new int[]{start[0], start[1], 0});
        dists[start[0]][start[1]] = 0;
        while (!toVisit.isEmpty()) {
            int[] now = toVisit.poll();
            if (visited[now[0]][now[1]]) continue;
            visited[now[0]][now[1]] = true;
            for (int[] delta : free) {
                int[] next = {now[0] + delta[0], now[1] + delta[1], now[2]};
                if (!checkBounds(next[0], next[1])) continue;
                if (map[next[0]][next[1]] == '#') continue;
                if (dists[next[0]][next[1]] < next[2]) continue;
                dists[next[0]][next[1]] = next[2];
                toVisit.add(next);
            }
            for (int[] delta : cost) {
                int[] next = {now[0] + delta[0], now[1] + delta[1], now[2] + 1};
                if (!checkBounds(next[0], next[1])) continue;
                if (map[next[0]][next[1]] == '#') continue;
                if (dists[next[0]][next[1]] < next[2]) continue;
                dists[next[0]][next[1]] = next[2];
                toVisit.add(next);
            }
        }
        int result = dists[goal[0]][goal[1]];
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static boolean checkBounds(int y, int x) {
        return y >= 0 && y < size[0] && x >= 0 && x < size[1];
    }
}
