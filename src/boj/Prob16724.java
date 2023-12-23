package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/16724
public class Prob16724 {
    private static final int[][] deltas = new int[4][];
    private static int[][] map;
    private static int[][] cycle;
    private static int count = 0;

    static {
        // D
        deltas[0] = new int[]{1, 0};
        // U
        deltas[1] = new int[]{-1, 0};
        // R
        deltas[2] = new int[]{0, 1};
        // L
        deltas[3] = new int[]{0, -1};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] mapInfo = reader.readLine().split(" ");
        int height = Integer.parseInt(mapInfo[0]);
        int width = Integer.parseInt(mapInfo[1]);
        map = new int[height][];
        for (int i = 0; i < height; i++) {
            map[i] = reader.readLine().chars()
                    .map(dir -> {
                        // cannot use enhanced switch: java 11
                        switch (dir) {
                            case 'D': return 0;
                            case 'U': return 1;
                            case 'R': return 2;
                            case 'L': return 3;
                            default: return -1;
                        }}).toArray();
        }

        cycle = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (cycle[i][j] != 2) dfs(new int[]{i, j});
            }
        }

        System.out.println(count);
    }

    private static void dfs(int[] now) {
        cycle[now[0]][now[1]] = 1;
        int[] delta = deltas[map[now[0]][now[1]]];
        int[] next = { now[0] + delta[0], now[1] + delta[1] };
        if (cycle[next[0]][next[1]] == 0) {
            dfs(next);
        }
        else if (cycle[next[0]][next[1]] == 1)
            count++;
        cycle[now[0]][now[1]] = 2;
    }
}
