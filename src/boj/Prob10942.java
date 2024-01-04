package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/10942
public class Prob10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] dp = new int[n][n];
        for (int i = 0; i < numbers.length; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            dp[i][i + 1] = numbers[i] == numbers[i + 1] ? 1 : 0;
        }

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = numbers[j] == numbers[j + i] && dp[j + 1][j + i - 1] == 1 ? 1 : 0;
            }
        }

        /*System.out.println();
        for (int[] row: dp) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();*/

        int rounds = Integer.parseInt(reader.readLine());
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < rounds; i++) {
            int[] round = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(str -> Integer.parseInt(str) - 1)
                    .toArray();
            answerBuilder.append(dp[round[0]][round[1]]);
            answerBuilder.append('\n');
        }
        System.out.print(answerBuilder);
    }
}
