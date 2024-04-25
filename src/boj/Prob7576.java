package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/7576
public class Prob7576 {
    private static final int[][] deltas = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    private static int width;
    private static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        width = nm[0];
        height = nm[1];

        Queue<int[]> toVisit = new LinkedList<>();
        int[][] tomatoRack = new int[height][];
        for (int i = 0; i < height; i++) {
            tomatoRack[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < width; j++) {
                if (tomatoRack[i][j] == 1) {
                    toVisit.offer(new int[]{i, j, 0});
                }
            }
        }

        int days = 0;
        while (!toVisit.isEmpty()) {
            int[] now = toVisit.poll();
            days = Math.max(days, now[2]);
            for (int[] delta: deltas) {
                int nextY = now[0] + delta[0];
                int nextX = now[1] + delta[1];
                if (checkBounds(nextY, nextX) &&
                        tomatoRack[nextY][nextX] != -1 &&
                        tomatoRack[nextY][nextX] != 1
                ) {
                    tomatoRack[nextY][nextX] = 1;
                    int nextDays = now[2] + 1;
                    toVisit.offer(new int[]{nextY, nextX, nextDays});
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (tomatoRack[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days);
    }

    private static boolean checkBounds(int y, int x) {
        return -1 < y && y < height && -1 < x && x < width;
    }

}
