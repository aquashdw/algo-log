package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/2638
public class Prob2638 {
    private static int n;
    private static int m;
    private static int[][] cheese;
    private static final int[][] DELTAS = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] cheeseSize = reader.readLine().split(" ");
        n = Integer.parseInt(cheeseSize[0]);
        m = Integer.parseInt(cheeseSize[1]);

        cheese = new int[n][];
        for (int i = 0; i < n; i++) {
            cheese[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int hours = 0;
        while (!melted()) {
            boolean[][] visited = new boolean[n][m];
            int[][] melt = new int[n][m];
            Queue<int[]> toVisit = new LinkedList<>();
            toVisit.offer(new int[]{0, 0});
            while (!toVisit.isEmpty()) {
                int[] now = toVisit.poll();
                if (visited[now[0]][now[1]]) continue;
                visited[now[0]][now[1]] = true;

                for (int[] delta : DELTAS) {
                    int nextY = now[0] + delta[0];
                    int nextX = now[1] + delta[1];
                    if (!checkBounds(nextY, nextX))
                        continue;

                    // 가지는 못하고 녹힌다.
                    if (cheese[nextY][nextX] == 1) {
                        melt[nextY][nextX]++;
                    }
                    else if (!visited[nextY][nextX]) {
                        toVisit.offer(new int[]{nextY, nextX});
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (melt[i][j] >= 2)
                        cheese[i][j] = 0;
                }
            }
            hours++;
        }

        System.out.println(hours);
    }

    public static boolean melted() {
        for (int[] row : cheese) {
            if (Arrays.stream(row).anyMatch(i -> i == 1))
                return false;
        }
        return true;
    }

    public static boolean checkBounds(int y, int x) {
        return 0 <= y && y < n &&
                0 <= x && x < m;
    }
}
