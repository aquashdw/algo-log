package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/17544
public class Prob17544 {
    private static final int[][] deltas = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1},
    };

    private static int rows;
    private static int cols;
    private static int bridges;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        rows = info[0];
        cols = info[1];
        bridges = info[2];
        map = new int[rows][];
        int maxHeight = 0;
        for (int i = 0; i < rows; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            maxHeight = Arrays.stream(map[i]).reduce(maxHeight, Math::max);
        }

        int low = 0;
        int high = maxHeight + 1;
        while (low + 1 < high) {
            int mid = (high + low) / 2;
            if (possible(mid)) low = mid;
            else high = mid;
        }
        System.out.println(low);
    }

    private static boolean possible(int height) {
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> nextQueue = new LinkedList<>();
        for (int j = 0; j < cols; j++) {
            if (map[0][j] >= height) queue.offer(new int[]{0, j});
            else nextQueue.offer(new int[]{0, j});
            visited[0][j] = true;
        }

        for (int i = 0; i < bridges + 1; i++) {
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                if (now[0] == rows - 1) return true;
                for (int[] delta : deltas) {
                    int nextY = now[0] + delta[0];
                    int nextX = now[1] + delta[1];
                    if (!checkBounds(nextY, nextX) || visited[nextY][nextX]) continue;
                    if (map[nextY][nextX] >= height) queue.offer(new int[]{nextY, nextX});
                    else nextQueue.offer(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                }
            }

            Queue<int[]> temp = queue;
            queue = nextQueue;
            nextQueue = temp;
        }

        return false;
    }

    public static boolean checkBounds(int y, int x) {
        return 0 <= y && y < rows &&
                0 <= x && x < cols;
    }
}
