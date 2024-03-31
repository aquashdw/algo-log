package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/18111
public class Prob18111 {
    private static int n;
    private static int m;
    private static int b;
    private static int[][] ground;
    private static int max;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nmb = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = nmb[0];
        m = nmb[1];
        b = nmb[2];
        ground = new int[n][];

        max = 0;
        min = 256;

        for (int i = 0; i < n; i++) {
            ground[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < m; j++) {
                max = Math.max(max, ground[i][j]);
                min = Math.min(min, ground[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int height = -1;
        for (int i = min; i < max + 1; i++) {
            int time = calculate(i);
            if (time <= minTime) {
                minTime = time;
                height = i;
            }
        }
        System.out.printf("%d %d%n", minTime, height);
    }

    private static int calculate(int height) {
        int required = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int diff = ground[i][j] - height;
                if (diff == 0) continue;
                // 음수면 더해지고 양수면 빼진다.
                required -= diff;
                if (ground[i][j] > height) {
                    time += 2 * diff;
                }
                else {
                    time -= diff;
                }
            }
        }
        if (required > b) return Integer.MAX_VALUE;
        else return time;
    }
}

