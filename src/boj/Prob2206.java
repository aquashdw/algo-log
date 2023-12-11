package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


// https://www.acmicpc.net/problem/2206
public class Prob2206 {
    private static int n;
    private static int m;
    private static final int[][] DELTAS = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] mapInfo = reader.readLine().split(" ");
        n = Integer.parseInt(mapInfo[0]);
        m = Integer.parseInt(mapInfo[1]);

        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = reader.readLine().toCharArray();
        }

        // y, x, price, break
        int[] start = {0, 0, 1, 0};
        int min = Integer.MAX_VALUE;
        Queue<int[]> toVisit = new LinkedList<>();
        toVisit.offer(start);
        boolean[][] beforeBreak = new boolean[n][m];
        boolean[][] afterBreak = new boolean[n][m];

        while (!toVisit.isEmpty()) {
            int[] now = toVisit.poll();
            boolean broken = now[3] == 1;
            if (broken && afterBreak[now[0]][now[1]])
                continue;
            else if (beforeBreak[now[0]][now[1]])
                continue;

            if (now[0] == n - 1 && now[1] == m - 1) {
                min = Math.min(min, now[2]);
                continue;
            }

            if (broken)
                afterBreak[now[0]][now[1]] = true;
            else
                beforeBreak[now[0]][now[1]] = true;

            for (int[] delta : DELTAS) {
                int nextY = now[0] + delta[0];
                int nextX = now[1] + delta[1];
                if (!checkBounds(nextY, nextX))
                    continue;

                boolean wall = map[nextY][nextX] == '1';
                // 벽이고 이미 벽을 깬적 있다.
                // => 갈수 없다.
                if (wall && broken) continue;
                // 벽이다.
                if (wall) {
                    // 벽을 깬 뒤로는 간적 없다.
                    if (!afterBreak[nextY][nextX])
                        toVisit.offer(new int[]{nextY, nextX, now[2] + 1, 1});
                }
                // 벽이 아니다.
                else {
                    // 깬적 있고, 깨기전후로 방문한적 없다.
                    if (broken && !beforeBreak[nextY][nextX] && !afterBreak[nextY][nextX])
                        toVisit.offer(new int[]{nextY, nextX, now[2] + 1, now[3]});
                    // 깬적 없고, 깨기 전에 방문한적 없다.
                    else if (!broken && !beforeBreak[nextY][nextX])
                        toVisit.offer(new int[]{nextY, nextX, now[2] + 1, now[3]});
                }
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static boolean checkBounds(int y, int x) {
        return 0 <= y && y < n &&
                0 <= x && x < m;
    }
}
