package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/11607
public class Prob11607 {
    private static final int[][] deltas = {
            {-1, 0},
            {0, -1},
            {0, 1},
            {1, 0},
    };
    private static int rows = 0;
    private static int cols = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] rc = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        rows = rc[0];
        cols = rc[1];

        int[][] grid = new int[rows][];
        for (int i = 0; i < rows; i++) {
            grid[i] = reader.readLine().chars()
                    .map(ch -> ch - '0').toArray();
        }

        int[][] visited = new int[rows][cols];
        Queue<int[]> toVisit = new LinkedList<>();
        toVisit.add(new int[]{0, 0, 0});
        while (!toVisit.isEmpty() && visited[rows - 1][cols - 1] == 0) {
            int[] now = toVisit.poll();
            int jump = grid[now[0]][now[1]];
            int dist = now[2] + 1;
            for (int[] delta : deltas) {
                int y = now[0] + delta[0] * jump;
                int x = now[1] + delta[1] * jump;
                if (!checkBounds(y, x) || visited[y][x] != 0) continue;
                visited[y][x] = dist;
                toVisit.add(new int[]{y, x, dist});
            }
        }
        int result = visited[rows - 1][cols - 1];
        System.out.println(result == 0 ? "IMPOSSIBLE" : result);
    }

    private static boolean checkBounds(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
