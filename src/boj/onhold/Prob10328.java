package boj.onhold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/10328
public class Prob10328 {
    private static final int[][] deltas = {
            // if front,
            {0, 1},
            {-1, 0},  // L
            {0, -1},  // B
            {1, 0},   // R
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(route -> {
            int farRight = 0;
            int topHeight = 0;
            int botHeight = 0;

            int[] now = {0, 0};
            Map<Integer, Set<Integer>> visited = new HashMap<>();
            visited.put(0, new HashSet<>());
            visited.get(0).add(0);
            int dir = 0;
            for (char move : route.toCharArray()) {
                int[] delta = switch (move) {
                    case 'F' -> deltas[dir];
                    case 'L' -> {
                        dir = (dir + 1) % 4;
                        yield deltas[dir];
                    }
                    case 'B' -> {
                        dir = (dir + 2) % 4;
                        yield deltas[dir];
                    }
                    case 'R' -> {
                        dir = (dir + 3) % 4;
                        yield deltas[dir];
                    }
                    default -> throw new IllegalArgumentException();
                };
                now[0] += delta[0];
                now[1] += delta[1];
                farRight = Math.max(now[1], farRight);
                topHeight = Math.min(now[0], topHeight);
                botHeight = Math.max(now[0], botHeight);
                visited.computeIfAbsent(now[0], (k) -> new HashSet<>())
                        .add(now[1]);
            }

            int height = botHeight - topHeight + 3;
            int width = farRight + 2;

            char[][] board = new char[height][width];
            for (char[] row : board) {
                Arrays.fill(row, '#');
            }

            int heightOffset = (-topHeight) + 1;
            for (int i = topHeight; i < botHeight + 1; i++) {
                int y = i + heightOffset;
                for (int x : visited.get(i)) board[y][x] = '.';
            }
            answer.append(String.format("%d %d%n", height, width));
            for (char[] row : board) {
                answer.append(row).append('\n');
            }
        });

        System.out.print(answer);
    }
}
