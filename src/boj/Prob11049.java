package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11049
public class Prob11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] dims = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int[] matrix = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            dims[i] = matrix[0];
            if (i == n - 1)
                dims[n] = matrix[1];
        }
        // lowestCost[i][j]는 i 부터 j까지의 행렬을 곱할때의 최소 곱셈 횟수
        int[][] lowestCost = new int[n][n];

        // 2개를 곱하는 것부터 전체를 곱하는 것까지 차례데로 탐색
        for (int subLen = 2; subLen <= n; subLen++) {
            for (int i = 0; i < n - subLen + 1; i++) {
                // i 부터 j 까지 subLen 길이가 되도록
                int j = i + subLen - 1;
                lowestCost[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int thisCost = lowestCost[i][k] + lowestCost[k + 1][j] + dims[i] * dims[k + 1] * dims[j + 1];
                    if (thisCost < lowestCost[i][j]) {
                        lowestCost[i][j] = thisCost;
                    }
                }
            }
        }

        System.out.println(lowestCost[0][n - 1]);
    }
}
