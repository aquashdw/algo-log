package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14500
public class Prob14500 {
    private static int height;
    private static int width;
    private static int[][] board;
    private static boolean[][] visited;
    private static final int[][] deltas = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    private static final int[][][] tBlocks = {
            {{0, -1}, {-1, 0}, {0, 1}},
            {{-1, 0}, {0, 1}, {1, 0}},
            {{0, 1}, {1, 0}, {0, -1}},
            {{1, 0}, {0, -1}, {-1, 0}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        height = nm[0];
        width = nm[1];
        board = new int[height][];
        visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            board[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                max = Math.max(dfsMax(i, j), max);
                max = Math.max(tBlockMax(i, j), max);
            }
        }

        System.out.println(max);
    }

    private static int tBlockMax(int y, int x) {
        int max = 0;
        for (int[][] tBlock: tBlocks) {
            boolean valid = true;
            int sum = board[y][x];
            for (int[] tBlockCell: tBlock) {
                int blockY = y + tBlockCell[0];
                int blockX = x + tBlockCell[1];
                if (!checkBounds(blockY, blockX)) {
                    valid = false;
                    break;
                }
                sum += board[blockY][blockX];
            }
            if (valid) max = Math.max(sum, max);
        }
        return max;
    }

    private static int dfsMax(int y, int x) {
        int max = 0;
        visited[y][x] = true;
        for (int[] delta: deltas) {
            int nextY = y + delta[0];
            int nextX = x + delta[1];
            if (checkBounds(nextY, nextX) && !visited[nextY][nextX]) {
                visited[nextY][nextX] = true;
                max = Math.max(dfsRecursive(
                        nextY, nextX,
                        1,
                        board[y][x] + board[nextY][nextX]
                ), max);
                visited[nextY][nextX] = false;
            }
        }
        visited[y][x] = false;
        return max;
    }

    private static int dfsRecursive(int nowY, int nowX, int depth, int sum) {
        if (depth == 3) {
            return sum;
        }
        int localMax = 0;
        for (int[] delta: deltas) {
            int nextY = nowY + delta[0];
            int nextX = nowX + delta[1];
            if (checkBounds(nextY, nextX) && !visited[nextY][nextX]) {
                visited[nextY][nextX] = true;
                localMax = Math.max(dfsRecursive(
                        nextY, nextX,
                        depth + 1,
                        sum + board[nextY][nextX]),
                        localMax
                );
                visited[nextY][nextX] = false;
            }
        }
        return localMax;
    }

    private static boolean checkBounds(int y, int x) {
        return -1 < y && y < height && -1 < x && x < width;
    }
}
