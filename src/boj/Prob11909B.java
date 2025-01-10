package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/11909
public class Prob11909B {
    private static final int[][] deltas = {
            {1, 0},
            {0, 1},
    };
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, 10000000);
        }
        dp[0][0] = 0;

        Queue<int[]> toVisit = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        toVisit.offer(new int[]{0, 0, 0});
        while (!toVisit.isEmpty()) {
            int[] now = toVisit.poll();

            for (int[] delta : deltas) {
                int nextY = now[0] + delta[0];
                int nextX = now[1] + delta[1];

                if (!checkBounds(nextY, nextX)) continue;
                int cost = now[2];
                if (map[nextY][nextX] >= map[now[0]][now[1]])
                    cost += map[nextY][nextX] - map[now[0]][now[1]] + 1;

                if (cost >= dp[nextY][nextX]) continue;
                dp[nextY][nextX] = cost;
                toVisit.offer(new int[]{nextY, nextX, dp[nextY][nextX]});
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }

    private static boolean checkBounds(int y, int x) {
        return -1 < x && x < n && -1 < y && y < n;
    }
}
