package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/21736
public class Prob21736 {
    private static int height;
    private static int width;
    private static int[][] deltas = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        height = nm[0];
        width = nm[1];

        char[][] campus = new char[height][width];
        int startY = -2;
        int startX = -2;
        boolean[][] visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            String line = reader.readLine();
            for (int j = 0; j < width; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    startY = i;
                    startX = j;
                    visited[i][j] = true;
                }
            }
        }

        Queue<int[]> toVisit = new LinkedList<>();
        toVisit.offer(new int[]{startY, startX});
        int people = 0;
        while (!toVisit.isEmpty()) {
            int[] now = toVisit.poll();
            for (int[] delta: deltas) {
                int nextY = now[0] + delta[0];
                int nextX = now[1] + delta[1];
                if (checkBounds(nextY, nextX) && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    if (campus[nextY][nextX] != 'X') {
                        toVisit.offer(new int[]{nextY, nextX});
                        if (campus[nextY][nextX] == 'P') people++;
                    }
                }
            }
        }
        System.out.println(people == 0 ? "TT" : people);
    }

    private static boolean checkBounds(int y, int x) {
        return -1 < y && y < height && -1 < x && x < width;
    }
}
