package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

// https://www.acmicpc.net/problem/4340
public class Prob4340 {
    private static final Map<Character, Character> loseTo = Map.of(
            'R', 'P',
            'P', 'S',
            'S', 'R'
    );

    private static final int[][] deltas = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    private static int height = 0;
    private static int width = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 1; test <= tests; test++) {
            int[] info = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            height = info[0];
            width = info[1];
            int days = info[2];

            char[][] world = new char[height][];
            for (int i = 0; i < height; i++) {
                world[i] = reader.readLine().toCharArray();
            }

            char[][] nextWorld = new char[height][width];
            for (int day = 0; day < days; day++) {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        char here = world[i][j];
                        char strong = loseTo.get(here);
                        boolean lose = false;
                        for (int[] delta : deltas) {
                            int nextY = i + delta[0];
                            int nextX = j + delta[1];
                            if (!checkBounds(nextX, nextY)) continue;
                            if (world[nextY][nextX] == strong) {
                                lose = true;
                                break;
                            }
                        }
                        nextWorld[i][j] = lose ? strong : here;
                    }
                }
                char[][] temp = world;
                world = nextWorld;
                nextWorld = temp;
            }

            for (int i = 0; i < height; i++) {
                answer.append(world[i]).append('\n');
            }
            if (test < tests) answer.append('\n');
        }
        System.out.print(answer);
    }

    private static boolean checkBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
/*
1
3 4 2
RSPR
SPRS
PRSP

RRSP
RSPR
SPRS

RRRS
RRSP
RSPR


 */
