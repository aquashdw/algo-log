package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/28420
public class Prob28420 {
    private static int[][] lot;
    private static int x;
    private static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] lotSize = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        x = lotSize[1];
        y = lotSize[0];
        int[] carSize = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean[][] shapeA = new boolean[carSize[0]][carSize[1] + carSize[2]];
        for (int i = 0; i < carSize[0]; i++) {
            Arrays.fill(shapeA[i], true);
        }

        boolean[][] shapeB = new boolean[carSize[1] + carSize[0]][carSize[2] + carSize[0]];
        for (int i = 0; i < carSize[0]; i++) {
            for (int j = 0; j < carSize[2]; j++) {
                shapeB[i][j] = true;
            }
        }
        for (int i = carSize[0]; i < carSize[1] + carSize[0]; i++) {
            for (int j = carSize[2]; j < carSize[2] + carSize[0]; j++) {
                shapeB[i][j] = true;
            }
        }

        boolean[][] shapeC = new boolean[carSize[2] + carSize[0]][carSize[1] + carSize[0]];
        for (int i = 0; i < carSize[0]; i++) {
            for (int j = 0; j < carSize[1]; j++) {
                shapeC[i][j] = true;
            }
        }
        for (int i = carSize[0]; i < carSize[2] + carSize[0]; i++) {
            for (int j = carSize[1]; j < carSize[1] + carSize[0]; j++) {
                shapeC[i][j] = true;
            }
        }
        lot = new int[y][];
        for (int i = 0; i < y; i++) {
            lot[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (doesFit(j, i, shapeA[0].length, shapeA.length)) {
                    min = Math.min(min, checkWeather(j, i, shapeA));
                }
                if (doesFit(j, i, shapeB[0].length, shapeB.length)) {
                    min = Math.min(min, checkWeather(j, i, shapeB));
                }
                if (doesFit(j, i, shapeC[0].length, shapeC.length)) {
                    min = Math.min(min, checkWeather(j, i, shapeC));
                }
            }
        }
        System.out.println(min);
    }

    private static int checkWeather(int startX, int startY, boolean[][] shape) {
        int sum = 0;
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (!shape[i][j]) continue;
                int x = startX + j;
                int y = startY + i;
                sum += lot[y][x];
            }
        }
        return sum;
    }

    private static boolean doesFit(int startX, int startY, int sizeX, int sizeY) {
        return startX + sizeX < x + 1 && startY + sizeY < y + 1;
    }
}

