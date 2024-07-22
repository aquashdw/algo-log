package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/4677
public class Prob4677 {
    private static int[][] deltas = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        while (true) {
            String line = reader.readLine();
            if (line.startsWith("0 ")) break;
            int[] info = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            char[][] map = new char[info[0]][];
            for (int i = 0; i < info[0]; i++) {
                map[i] = reader.readLine().toCharArray();
            }
            answer.append(deposits(map)).append('\n');
        }
        System.out.print(answer);
    }

    private static int deposits(char[][] map) {
        int m = map.length;
        int n = map[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '*') continue;
                count++;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    for (int[] delta : deltas) {
                        int nextY = now[0] + delta[0];
                        int nextX = now[1] + delta[1];
                        if (checkBounds(m, n, nextY, nextX) && map[nextY][nextX] == '@') {
                            map[nextY][nextX] = '*';
                            queue.offer(new int[]{nextY, nextX});
                        }
                    }
                }
            }
        }
        return count;
    }

    private static boolean checkBounds(int m, int n, int y, int x) {
        return -1 < y && y < m && -1 < x && x < n;
    }
}
