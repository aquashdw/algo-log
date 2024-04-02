package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


// https://www.acmicpc.net/problem/1012
public class Prob1012 {
    private static int[][] garden;
    private static int x;
    private static int y;

    private static int[][] deltas = {
            {0, 1}, {0, -1}, {1, 0}, {-1 , 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            int[] info = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            x = info[0];
            y = info[1];
            garden = new int[x][y];
            reader.lines().limit(info[2])
                    .forEach(line -> {
                        int[] cabbage = Arrays.stream(line.split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                        garden[cabbage[0]][cabbage[1]] = 1;
                    });

            answer.append(countWorms()).append('\n');
        }
        System.out.print(answer);
    }

    private static int countWorms() {
        int worms = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (garden[i][j] == 1) {
                    worms++;
                    bfs(i, j);
                }
            }
        }
        return worms;
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int[] delta: deltas) {
                int nextX = now[0] + delta[0];
                int nextY = now[1] + delta[1];
                if (checkBounds(nextX, nextY) && garden[nextX][nextY] == 1) {
                    garden[nextX][nextY] = 0;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }

    private static boolean checkBounds(int i, int j) {
        return -1 < i && i < x && -1 < j && j < y;
    }
}
