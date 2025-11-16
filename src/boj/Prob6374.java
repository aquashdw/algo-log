package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/6374
public class Prob6374 {
    private static int[][] sums;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> nums = new ArrayList<>(n * n);
        while (nums.size() < n * n) {
            String line = reader.readLine();
            if (line.isEmpty()) continue;
            Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).forEach(nums::add);
        }
        sums = new int[n + 1][n + 1];
        for (int i = 0; i < n * n; i++) {
            sums[i / n + 1][i % n + 1] = nums.get(i);
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sums[i + 1][j + 1] += sums[i + 1][j];
            }
            for (int j = 0; j < n; j++) {
                sums[i + 1][j + 1] += sums[i][j + 1];
            }

        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                calculate(i, j);
            }
        }
        System.out.println(max);
    }

    private static void calculate(int y, int x) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                max = Math.max(max, sums[y][x] - sums[i][x] - sums[y][j] + sums[i][j]);
            }
        }
    }
}
