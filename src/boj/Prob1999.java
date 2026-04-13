package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/1999
public class Prob1999 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nbk = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int n = nbk[0];
        int[][] numbers = reader.lines().limit(n)
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);

        int b = nbk[1];
        int subLen = n - b + 1;
        int[][] diffs = new int[subLen][subLen];
        for (int i = 0; i < subLen; i++) {
            for (int j = 0; j < subLen; j++) {
                int maxNum = 0;
                int minNum = 250;
                for (int k = 0; k < b; k++) {
                    for (int l = 0; l < b; l++) {
                        maxNum = Math.max(maxNum, numbers[i + k][j + l]);
                        minNum = Math.min(minNum, numbers[i + k][j + l]);
                    }
                }
                diffs[i][j] = maxNum - minNum;
            }
        }

        System.out.println(reader.lines().limit(nbk[2])
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt).toArray())
                .map(ij -> String.valueOf(diffs[ij[0] - 1][ij[1] - 1]))
                .collect(Collectors.joining("\n")));

    }
}
