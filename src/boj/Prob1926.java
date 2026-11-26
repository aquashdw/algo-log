package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


// https://acmicpc.net/problem/1926
public class Prob1926 {
    private static int n;
    private static int m;
    private static final int[][] deltas = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        n = info[0];
        m = info[1];

        int[][] paper = reader.lines().limit(n)
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);

        Queue<int[]> toVisit = new ArrayDeque<>();
        int count = 0;
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 0) continue;
                toVisit.add(new int[]{i, j});
                paper[i][j] = 0;
                count++;
                int size = 1;
                while (!toVisit.isEmpty()) {
                    int[] now = toVisit.poll();
                    for (int[] delta : deltas) {
                        int nextY = now[0] + delta[0];
                        int nextX = now[1] + delta[1];
                        if (!checkBounds(nextY, nextX) || paper[nextY][nextX] != 1) continue;
                        size++;
                        toVisit.add(new int[]{nextY, nextX});
                        paper[nextY][nextX] = 0;
                    }
                }
                if (size > maxSize) maxSize = size;
            }
        }

        System.out.printf("%d%n%d%n", count, maxSize);
    }

    private static boolean checkBounds(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
