package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/9993
public class Prob9993 {
    private static char[][] field = null;
    private static final int[][] deltas = {
            {1, 0},  // d - /:l, \:r
            {0, 1},   // r - /:u, \:d
            {-1, 0},   // u - /:r, \:l
            {0, -1},  // l - /:d, \:u
    };
    private static int rows = 0;
    private static int cols = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] rc = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        rows = rc[0];
        cols = rc[1];
        field = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            field[i] = reader.readLine().toCharArray();
        }

        int maxBounce = 0;
        for (int i = 0; i < rows; i++) {
            maxBounce = Math.max(maxBounce, beam(i, 0, 1));
            maxBounce = Math.max(maxBounce, beam(i, cols - 1, 3));
        }
        for (int i = 0; i < cols; i++) {
            maxBounce = Math.max(maxBounce, beam(0, i, 0));
            maxBounce = Math.max(maxBounce, beam(rows - 1, i, 2));
        }
        System.out.println(maxBounce != Integer.MAX_VALUE ? maxBounce : -1);
    }

    private static int beam(int startY, int startX, int dir) {
        int bounces = 0;
        int[] toVisit = {startY, startX, dir};
//        System.out.println("start");
        while (checkBounds(toVisit[0], toVisit[1])) {
//            System.out.println(Arrays.toString(toVisit));
            bounces++;
            int bounce = (field[toVisit[0]][toVisit[1]] == '/' ? 1 : -1) * (toVisit[2] % 2 == 0 ? -1 : 1);
            int newDir = (toVisit[2] + bounce + 4) % 4;
            int[] delta = deltas[newDir];
            toVisit[0] += delta[0];
            toVisit[1] += delta[1];
            toVisit[2] = newDir;
        }
//        System.out.println(Arrays.toString(toVisit));
//        System.out.println(bounces);
        return bounces;
    }


    private static boolean checkBounds(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

}
