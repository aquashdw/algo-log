package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5991
public class Prob5991 {
    private static final int[][] deltas = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1},
    };

    private static int height;
    private static int width;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] rc = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        height = rc[0];
        width = rc[1];

        int[][] farm = reader.lines().limit(height)
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);

        int[] now = {0, 0};
        int total = farm[0][0];
        farm[0][0] = 0;
        while (!(now[0] == height - 1 && now[1] == width - 1)) {
            int maxFruit = 0;
            int nextDir = -1;
            for (int i = 0; i < deltas.length; i++) {
                int[] delta = deltas[i];
                int nextY = now[0] + delta[0];
                int nextX = now[1] + delta[1];
                if (checkBounds(nextY, nextX) && farm[nextY][nextX] > maxFruit) {
                    maxFruit = farm[nextY][nextX];
                    nextDir = i;
                }
            }
            total += maxFruit;
            now[0] += deltas[nextDir][0];
            now[1] += deltas[nextDir][1];
            farm[now[0]][now[1]] = 0;
        }
        System.out.println(total);
    }

    private static boolean checkBounds(int y, int x) {
        return 0 <= y && y < height && 0 <= x && x < width;
    }
}
