package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/1445
public class Prob1445 {
    private static final int[][] deltas = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };
    private static char[][] board;
    private static int height;
    private static int width;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        height = nm[0];
        width = nm[1];
        board = new char[height][];
        int[] start = new int[2];
        int[] goal = new int[2];
        for (int i = 0; i < height; i++) {
            String line = reader.readLine();
            if (line.contains("F")) {
                goal[0] = i;
                goal[1] = line.indexOf("F");
            }
            if (line.contains("S")) {
                start[0] = i;
                start[1] = line.indexOf("S");
            }
            board[i] = line.toCharArray();
        }

        int[][][] visited = new int[height + 1][width + 1][2];
        for (int[][] row : visited) {
            for (int[] values : row) Arrays.fill(values, Integer.MAX_VALUE);
        }
        Queue<int[]> toVisit = new PriorityQueue<>(((o1, o2) -> {
            if (o1[2] == o2[2]) return o1[3] - o2[3];
            return o1[2] - o2[2];
        }));
        toVisit.offer(new int[]{start[0], start[1], 0, 0});
        while (!toVisit.isEmpty()) {
            int[] now = toVisit.poll();
            if (board[now[0]][now[1]] == 'F') {
                System.out.printf("%d %d%n", now[2], now[3]);
                return;
            }
            for (int[] delta : deltas) {
                int nextY = now[0] + delta[0];
                int nextX = now[1] + delta[1];
                if (checkBounds(nextY, nextX)) {
                    int[] next = makeNext(nextY, nextX, now[2], now[3]);
                    if (next[2] <= visited[nextY][nextX][0] && next[3] < visited[nextY][nextX][1]) {
                        visited[nextY][nextX][0] = next[2];
                        visited[nextY][nextX][1] = next[3];
                        toVisit.offer(next);
                    }
                }
            }
        }
    }

    private static boolean checkBounds(int y, int x) {
        return -1 < y && y < height && -1 < x && x < width;
    }

    private static int[] makeNext(int nextY, int nextX, int garbage, int pass) {
        if (board[nextY][nextX] == 'F')
            return new int[]{nextY, nextX, garbage, pass};
        if (board[nextY][nextX] == 'g')
            return new int[]{nextY, nextX, garbage + 1, pass};

        boolean passes = false;
        for (int[] delta : deltas) {
            int checkY = nextY + delta[0];
            int checkX = nextX + delta[1];
            if (checkBounds(checkY, checkX) && board[checkY][checkX] == 'g') {
                passes = true;
                break;
            }
        }
        return new int[]{nextY, nextX, garbage, pass + (passes ? 1 : 0)};
    }
}
