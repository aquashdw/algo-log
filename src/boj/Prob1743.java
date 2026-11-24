package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


// https://acmicpc.net/problem/1743
public class Prob1743 {
    private static final int[][] deltas = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
    };
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        n = info[0];
        m = info[1];

        boolean[][] map = new boolean[n][m];
        boolean[][] visited = new boolean[n][m];
        reader.lines().map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt).toArray())
                .limit(info[2])
                .forEach(trash -> map[trash[0] - 1][trash[1] - 1] = true);

        int maxTrash = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) continue;
                if (!map[i][j]) continue;

                Queue<int[]> toVisit = new ArrayDeque<>();
                toVisit.offer(new int[]{i, j});
                visited[i][j] = true;
                int size = 1;
                while (!toVisit.isEmpty()) {
                    int[] now = toVisit.poll();
                    for (int[] delta : deltas) {
                        int nextY = now[0] + delta[0];
                        int nextX = now[1] + delta[1];
                        if (!checkBounds(nextY, nextX)) continue;
                        if (visited[nextY][nextX] || !map[nextY][nextX]) continue;
                        visited[nextY][nextX] = true;
                        toVisit.offer(new int[]{nextY, nextX});
                        size++;
                    }
                }
                maxTrash = Math.max(maxTrash, size);
            }
        }
        System.out.println(maxTrash);
    }

    private static boolean checkBounds(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
