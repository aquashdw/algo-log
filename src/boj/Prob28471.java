package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/28471
public class Prob28471 {
    private static final int[][] deltas = {
            {-1, 0},
            {0, -1},
            {0, 1},
            {-1, -1},
            {1, -1},
            {-1, 1},
            {1, 1},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] start = null;
        char[][] board = new char[n][];
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            int idx;
            if ((idx = line.indexOf('F')) != -1) {
                start = new int[]{i, idx};
            }
            board[i] = line.toCharArray();
        }

        if (start == null) throw new IllegalArgumentException();

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> toVisit = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        toVisit.add(start);
        int count = 0;
        while (!toVisit.isEmpty()) {
            int[] now = toVisit.poll();
            for (int[] delta : deltas) {
                int nextY = now[0] + delta[0];
                int nextX = now[1] + delta[1];
                if (!(0 <= nextY && nextY < n && 0 <= nextX && nextX < n)) continue;
                if (visited[nextY][nextX]) continue;
                if (board[nextY][nextX] == '#') continue;
                visited[nextY][nextX] = true;
                count++;
                toVisit.offer(new int[]{nextY, nextX});
            }
        }
        System.out.println(count);
    }
}
