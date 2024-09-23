package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/6881
public class Prob6881 {
    private static final int[][] deltas = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };
    private static int width;
    private static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        width = nm[0];
        height = nm[1];
        int[][] matrix = new int[height][];
        for (int i = 0; i < height; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Set<Integer> allowed = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[height][width];

        for (int i = 0; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    allowed.add(i);
                    allowed.add(j);
                    allowed.add(k);
                    for (int l = 0; l < width; l++) {
                        if (allowed.contains(matrix[0][l])) queue.add(new int[]{0, l});
                    }

                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        for (int[] delta : deltas) {
                            int nextY = now[0] + delta[0];
                            int nextX = now[1] + delta[1];
                            if (
                                    checkBounds(nextX, nextY) &&
                                            allowed.contains(matrix[nextY][nextX]) &&
                                            !visited[nextY][nextX]
                            ) {
                                if (nextY == height - 1) {
                                    System.out.printf("%d %d %d%n", i, j, k);
                                    return;
                                }
                                visited[nextY][nextX] = true;
                                queue.add(new int[]{nextY, nextX});
                            }
                        }
                    }

                    allowed.clear();
                    for (boolean[] visitRow : visited) {
                        Arrays.fill(visitRow, false);
                    }
                }
            }
        }
        System.out.println("-1 -1 -1");
    }

    private static boolean checkBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}