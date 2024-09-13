package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1080
public class Prob1080 {
    private static int[] size;
    private static int[][] source;
    private static int[][] target;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        size = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        source = new int[size[0]][];
        target = new int[size[0]][];

        for (int i = 0; i < size[0]; i++) {
            source[i] = reader.readLine().chars()
                    .map(c -> c - '0')
                    .toArray();
        }
        for (int i = 0; i < size[0]; i++) {
            target[i] = reader.readLine().chars()
                    .map(c -> c - '0')
                    .toArray();
        }

        int count = 0;
        for (int i = 0; i < size[0] - 2; i++) {
            for (int j = 0; j < size[1] - 2; j++) {
                if (source[i][j] != target[i][j]) {
                    operate(i, j);
                    count++;
                }
            }
        }

        System.out.println(isSame() ? count : -1);
    }

    private static void operate(int y, int x) {
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                source[i][j] = 1 - source[i][j];
            }
        }
    }

    private static boolean isSame(){
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                if (source[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }
}
