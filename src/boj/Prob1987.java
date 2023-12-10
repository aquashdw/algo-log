package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/1987
public class Prob1987 {
    private static final int[][] DELTAS = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    private static int height;
    private static int width;

    private static int[][] map;
    private static int max = Integer.MIN_VALUE;


    private static boolean checkBounds(int y, int x) {
        return 0 <= x && x < width && 0 <= y && y < height;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        height = size[0];
        width = size[1];
        map = new int[height][];

        for (int i = 0; i < height; i++) {
            map[i] = reader.readLine().chars()
                    .map(a -> a - 'A')
                    .toArray();
        }
        dfs();
        System.out.println(max);
    }

    public static void dfs() {
        boolean[] visited = new boolean[26];
        visited[map[0][0]] = true;
        dfsRecursive(1, 0, 0, visited);
    }

    public static void dfsRecursive(int depth, int y, int x, boolean[] visited) {
        max = Math.max(depth, max);
        for (int[] delta : DELTAS){
            int nextY = y + delta[0];
            int nextX = x + delta[1];
            if (!checkBounds(nextY, nextX) || visited[map[nextY][nextX]]) continue;
            visited[map[nextY][nextX]] = true;
            dfsRecursive(depth + 1, nextY, nextX, visited);
            visited[map[nextY][nextX]] = false;
        }
    }
}
