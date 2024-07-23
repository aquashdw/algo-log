package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14596
public class Prob14596 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] hw = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] image1 = new int[hw[0]][];
        for (int i = 0; i < hw[0]; i++) {
            image1[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int[][] image2 = new int[hw[0]][];
        for (int i = 0; i < hw[0]; i++) {
            image2[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] dp = new int[hw[0]][hw[1]];
        for (int i = 0; i < hw[1]; i++) {
            int diff = Math.abs(image1[0][i] - image2[0][i]);
            dp[0][i] = diff * diff;
        }

        for (int i = 1; i < hw[0]; i++) {
            for (int j = 0; j < hw[1]; j++) {
                int diff = Math.abs(image1[i][j] - image2[i][j]);
                diff *= diff;
                int min = diff + dp[i - 1][j];
                if (j != 0) {
                    min = Math.min(min, dp[i - 1][j - 1] + diff);
                }
                if (j != hw[1] - 1) {
                    min = Math.min(min, dp[i - 1][j + 1] + diff);
                }
                dp[i][j] = min;
            }
        }

        Arrays.stream(dp[hw[0] - 1]).min().ifPresent(System.out::println);
    }
}
