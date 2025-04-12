package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1233
public class Prob1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dice = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] sums = new int[Arrays.stream(dice).sum() + 1];
        for (int i = 0; i < dice[0]; i++) {
            for (int j = 0; j < dice[1]; j++) {
                for (int k = 0; k < dice[2]; k++) {
                    sums[i + j + k + 3] += 1;
                }
            }
        }
        int maxIdx = 0;
        int maxSum = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > maxSum) {
                maxSum = sums[i];
                maxIdx = i;
            }
        }
        System.out.println(maxIdx);
    }
}
