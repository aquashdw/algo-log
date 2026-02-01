package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/16973
public class Prob16973 {
    private static int[][] grid;
    private static int[] square;
    private static final int[][] deltas = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] rc = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        grid = new int[rc[0]][];
        for (int i = 0; i < rc[0]; i++) {
            grid[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        square = new int[]{info[0], info[1]};
        int[] start = {info[2] - 1, info[3] - 1};
        int[] end = {info[4] - 1, info[5] - 1};

        int[][] visited = new int[rc[0]][rc[1]];
        for (int[] row : visited) {
            Arrays.fill(row, -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        visited[start[0]][start[1]] = 0;
        queue.offer(new int[]{start[0], start[1], 0});
        while (!queue.isEmpty() && visited[end[0]][end[1]] == -1) {
            int[] now = queue.poll();
            for (int[] delta : deltas) {
                int y = now[0] + delta[0];
                int x = now[1] + delta[1];
                if (!checkMove(y, x) || visited[y][x] != -1) continue;
                visited[y][x] = now[2] + 1;
                queue.offer(new int[]{y, x, visited[y][x]});
            }
        }

        System.out.println(visited[end[0]][end[1]]);
    }

    private static boolean checkMove(int y, int x) {
        if (x < 0 || y < 0) return false;
        int farY = y + square[0] - 1;
        int farX = x + square[1] - 1;
        if (farY > grid.length - 1 || farX > grid[0].length - 1) return false;
        for (int i = 0; i < square[0]; i++) {
            if (grid[y + i][x] == 1) return false;
            if (grid[y + i][farX] == 1) return false;
        }
        for (int i = 0; i < square[1]; i++) {
            if (grid[y][x + i] == 1) return false;
            if (grid[farY][x + i] == 1) return false;
        }
        return true;
    }
}
