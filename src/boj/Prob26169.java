package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/26169
public class Prob26169 {
    private static final int[][] deltas = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };
    private static final int[][] board = new int[5][];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            board[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int[] start = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(dfs(start, 0, 0) ? 1 : 0);
    }

    private static boolean dfs(int[] now, int moves, int apples) {
        int here = board[now[0]][now[1]];
        apples += here == 1 ? 1 : 0;
        if (apples == 2) return true;
        if (moves == 3) return false;
        board[now[0]][now[1]] = -1;
        for (int[] delta : deltas) {
            int nextY = now[0] + delta[0];
            int nextX = now[1] + delta[1];
            if (!checkBounds(nextY, nextX) || board[nextY][nextX] == -1) continue;
            if (dfs(new int[]{nextY, nextX}, moves + 1, apples)) return true;
        }
        board[now[0]][now[1]] = here;
        return false;
    }

    private static boolean checkBounds(int y, int x) {
        return y >= 0 && y < 5 && x >= 0 && x < 5;
    }
}
