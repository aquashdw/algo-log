package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/18221
public class Prob18221 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] students = new int[n][];
        int[] prof = new int[2];
        int[] fugitive = new int[2];
        for (int i = 0; i < n; i++) {
            students[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < n; j++) {
                if (students[i][j] == 5) {
                    prof[0] = i;
                    prof[1] = j;
                }
                if (students[i][j] == 2) {
                    fugitive[0] = i;
                    fugitive[1] = j;
                }
            }
        }

        int yDiff = prof[0] - fugitive[0];
        int xDiff = prof[1] - fugitive[1];
        if (yDiff * yDiff + xDiff * xDiff < 25) {
            System.out.println(0);
            return;
        }

        int[] rowRange = new int[2];
        int[] colRange = new int[2];
        rowRange[0] = Math.min(prof[0], fugitive[0]);
        rowRange[1] = rowRange[0] + Math.abs(fugitive[0] - prof[0]) + 1;
        colRange[0] = Math.min(prof[1], fugitive[1]);
        colRange[1] = colRange[0] + Math.abs(fugitive[1] - prof[1]) + 1;

        int saboteurs = 0;
        for (int i = rowRange[0]; i < rowRange[1]; i++) {
            for (int j = colRange[0]; j < colRange[1]; j++) {
                if (students[i][j] == 1) saboteurs++;
                if (saboteurs == 3) break;
            }
            if (saboteurs == 3) break;
        }
        System.out.println(saboteurs == 3 ? 1 : 0);
    }
}
