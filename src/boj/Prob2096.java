package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2096
public class Prob2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] numbers = new int[n][];
        for (int i = 0; i < n; i++) {
            numbers[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] maxMem = new int[n][3];
        int[][] minMem = new int[n][3];
        maxMem[0] = numbers[0];
        minMem[0] = numbers[0];
        for (int i = 1; i < n; i++) {
            maxMem[i][0] = numbers[i][0] + Math.max(maxMem[i - 1][0], maxMem[i - 1][1]);
            maxMem[i][1] = numbers[i][1] + Arrays.stream(maxMem[i - 1])
                    .max().orElse(0);
            maxMem[i][2] = numbers[i][2] + Math.max(maxMem[i - 1][1], maxMem[i - 1][2]);

            minMem[i][0] += numbers[i][0] + Math.min(minMem[i - 1][0], minMem[i - 1][1]);
            minMem[i][1] += numbers[i][1] + Arrays.stream(minMem[i - 1])
                    .min().orElse(0);
            minMem[i][2] += numbers[i][2] + Math.min(minMem[i - 1][1], minMem[i - 1][2]);
        }

        StringBuilder answerBuilder = new StringBuilder();
        answerBuilder.append(Arrays.stream(maxMem[n - 1]).max().orElse(0));
        answerBuilder.append(" ");
        answerBuilder.append(Arrays.stream(minMem[n - 1]).min().orElse(0));
        System.out.println(answerBuilder);
    }
}
