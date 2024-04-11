package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/2178
public class Prob2178 {
    private static int[][] deltas = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mapInfo = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = mapInfo[0];
        m = mapInfo[1];
        int[][] map = new int[n][];
        for (int i = 0; i < n; i++) {
            map[i] = reader.readLine().chars()
                    .map(ch -> ch - '0')
                    .toArray();
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == n - 1 && now[1] == m - 1) {
                min = now[2];
                break;
            }
            for (int[] delta: deltas) {
                int nextY = now[0] + delta[0];
                int nextX = now[1] + delta[1];
                if (checkBounds(nextY, nextX) && map[nextY][nextX] == 1) {
                    map[nextY][nextX] = 0;
                    queue.offer(new int[]{nextY, nextX, now[2] + 1});
                }
            }
        }
        System.out.println(min);
    }

    private static boolean checkBounds(int y, int x) {
        return -1 < y && y < n && -1 < x && x < m;
    }
}
