package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/10026
public class Prob10026 {
    private static int n;
    private static final int[][] deltas = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        char[][] image = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < n; j++) {
                image[i][j] = line.charAt(j);
            }
        }

        boolean[][] nVisited = new boolean[n][n];
        boolean[][] bVisited = new boolean[n][n];
        int nCount = 0;
        int bCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nVisited[i][j]) continue;
                nCount++;
                char start = image[i][j];
                nVisited[i][j] = true;
                if (!bVisited[i][j]) {
                    bCount++;
                    bVisited[i][j] = true;
                }

                Queue<int[]> nToVisit = new LinkedList<>();
                Queue<int[]> bToVisit = new LinkedList<>();
                nToVisit.offer(new int[]{i, j});
                while (!nToVisit.isEmpty()) {
                    int[] now = nToVisit.poll();
                    for (int[] delta: deltas) {
                        int nextY = now[0] + delta[0];
                        int nextX = now[1] + delta[1];
                        if (checkBounds(nextY, nextX)) {
                            if (nVisited[nextY][nextX]) continue;
                            if (image[nextY][nextX] == start) {
                                if (!nVisited[nextY][nextX]) {
                                    nToVisit.offer(new int[]{nextY, nextX});
                                    nVisited[nextY][nextX] = true;
                                    bVisited[nextY][nextX] = true;
                                }
                            }
                            else if (Math.abs(image[nextY][nextX] - start) == 'R' - 'G') {
                                if (!bVisited[nextY][nextX]) {
                                    bToVisit.offer(new int[]{nextY, nextX});
                                    bVisited[nextY][nextX] = true;
                                }
                            }
                        }
                    }
                }

                while (!bToVisit.isEmpty()) {
                    int[] now = bToVisit.poll();
                    for (int[] delta: deltas) {
                        int nextY = now[0] + delta[0];
                        int nextX = now[1] + delta[1];
                        if (
                                checkBounds(nextY, nextX) &&
                                (image[nextY][nextX] == 'G' || image[nextY][nextX] == 'R') &&
                                !bVisited[nextY][nextX]
                        ) {
                            bVisited[nextY][nextX] = true;
                            bToVisit.offer(new int[]{nextY, nextX});
                        }
                    }
                }
            }
        }

        System.out.printf("%d %d%n", nCount, bCount);
    }

    private static boolean checkBounds(int y, int x) {
        return -1 < y && y < n && -1 < x && x < n;
    }
}

