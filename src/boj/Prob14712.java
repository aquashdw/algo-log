package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14712
public class Prob14712 {
    private static boolean[][] board;
    private static long count = 0;
    private static int y;
    private static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        y = nm[0];
        x = nm[1];
        board = new boolean[y][x];
        dfs(0, 0);
        System.out.println(count);
    }

    private static void dfs(int nowY, int nowX) {
        if (nowY == y) {
            count++;
            return;
        }
        int nextX = nowX + 1;
        int nextY = nowY;
        if (nextX == x) {
            nextY++;
            nextX = 0;
        }
        dfs(nextY, nextX);
        board[nowY][nowX] = true;
        if (checkLU(nowY, nowX)) dfs(nextY, nextX);
        board[nowY][nowX] = false;
    }

    private static boolean checkLU(int y, int x) {
        if (x == 0 || y == 0) return true;
        return !(board[y][x] && board[y][x - 1] && board[y - 1][x] && board[y - 1][x - 1]);
    }
}
