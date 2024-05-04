package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/14940
public class Prob14940 {
    private static int[][] deltas = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    private static int height;
    private static int width;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        height = nm[0];
        width = nm[1];
        int[][] map = new int[height][width];
        int[] start = new int[3];
        for (int i = 0; i < height; i++) {
            String[] col = reader.readLine().split(" ");
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(col[j]);
                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                    map[i][j] = 0;
                }
            }
        }
        boolean[][] visited = new boolean[height][width];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int[] delta: deltas) {
                int nextY = now[0] + delta[0];
                int nextX = now[1] + delta[1];
                if (checkBounds(nextY, nextX) && map[nextY][nextX] != 0 && !visited[nextY][nextX]) {
                    map[nextY][nextX] = now[2] + 1;
                    visited[nextY][nextX] = true;
                    queue.offer(new int[]{ nextY, nextX, now[2] + 1 });
                }
            }
        }
//        System.out.println(Arrays.deepToString(map));
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] != 0) map[i][j] = -1;
            }
        }

        StringBuilder answer = new StringBuilder();
        Arrays.stream(map).forEach(col -> {
            Arrays.stream(col).forEach(num -> answer.append(num).append(' '));
            answer.append('\n');
        });
        System.out.print(answer);
    }

    private static boolean checkBounds(int y, int x) {
        return -1 < x && x < width && -1 < y && y < height;
    }
}
