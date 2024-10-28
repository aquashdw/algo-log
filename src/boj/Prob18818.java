package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/18818
public class Prob18818 {
    private static int n;
    private static char[][] board;
    private static int[][] deltas = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = reader.readLine().toCharArray();
        }

        int[][] visited = new int[n][n];
        for (int[] visitRow: visited) Arrays.fill(visitRow, Integer.MAX_VALUE);
        visited[0][0] = 1;
        Queue<int[]> toVisit = new LinkedList<>();
        // y, x, d, c
        toVisit.add(new int[]{0, 0, 0, 1});
        toVisit.add(new int[]{0, 0, 1, 1});
        while (!toVisit.isEmpty()) {
            int[] now = toVisit.poll();
            if (now[3] > visited[now[0]][now[1]]) continue;
            for (int i = 0; i < 4; i++) {
                int[] delta = deltas[i];
                int nextY = now[0] + delta[0];
                int nextX = now[1] + delta[1];
                if (!checkBounds(nextY, nextX)) continue;
                if (board[nextY][nextX] == '#') continue;
                int commands = now[3];
                commands += now[2] == i ? 0 : 1;
                if (visited[nextY][nextX] < commands) continue;
                visited[nextY][nextX] = commands;
                toVisit.add(new int[]{nextY, nextX, i, commands});
            }
        }
        System.out.println(visited[n - 1][n - 1]);
    }

    private static boolean checkBounds(int y, int x) {
        return -1 < y && y < n && -1 < x && x < n;
    }

}
