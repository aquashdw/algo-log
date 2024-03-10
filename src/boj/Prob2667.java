package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://www.acmicpc.net/problem/2667
public class Prob2667 {
    private static int n;
    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = reader.readLine().chars()
                    .map(a -> a - '0')
                    .toArray();
        }

        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    counts.add(bfs(i, j));
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append(counts.size()).append('\n');
        counts.stream()
                .sorted()
                .forEach(i -> answer.append(i).append('\n'));
        System.out.println(answer);
    }

    private static int bfs(int y, int x) {
        Queue<int[]> toVisit = new LinkedList<>();
        toVisit.offer(new int[]{y, x});
        map[y][x] = 0;
        int count = 0;
        while (!toVisit.isEmpty()) {
            int[] now = toVisit.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if (
                        checkBounds(nextY, nextX) &&
                        map[nextY][nextX] == 1
                ) {
                    map[nextY][nextX] = 0;
                    toVisit.offer(new int[]{nextY, nextX});
                }
            }
        }

        return count;
    }

    private static boolean checkBounds(int y, int x) {
        return -1 < y && y < n && -1 < x && x < n;
    }
}
