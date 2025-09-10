package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/9311
public class Prob9311 {
    private static final int[][] deltas = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };
    private static int rows = 0;
    private static int cols = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int[] rc = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            rows = rc[0];
            cols = rc[1];

            char[][] maze = new char[rows][];
            int[] start = new int[3];
            for (int i = 0; i < rows; i++) {
                maze[i] = reader.readLine().toCharArray();
                for (int j = 0; j < rc[1]; j++) {
                    if (maze[i][j] == 'S') {
                        start[0] = i;
                        start[1] = j;
                        maze[i][j] = 'X';
                    }
                }
            }

            Queue<int[]> toVisit = new LinkedList<>();
            toVisit.add(start);
            int dist = Integer.MAX_VALUE;
            while (!toVisit.isEmpty()) {
                int[] now = toVisit.poll();
                if (now[2] >= dist) break;
                for (int[] delta : deltas) {
                    int y = now[0] + delta[0];
                    int x = now[1] + delta[1];
                    if (!checkBounds(y, x) || maze[y][x] == 'X') continue;
                    if (maze[y][x] == 'G') {
                        dist = now[2] + 1;
                        continue;
                    }
                    maze[y][x] = 'X';
                    toVisit.add(new int[]{y, x, now[2] + 1});
                }
            }
            if (dist < Integer.MAX_VALUE) answer.append(String.format("Shortest Path: %d%n", dist));
            else answer.append("No Exit\n");
        }
        System.out.print(answer);
    }

    private static boolean checkBounds(int y, int x) {
        return 0 <= y && y < rows && 0 <= x && x < cols;
    }
}
