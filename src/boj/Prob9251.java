package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/9251
public class Prob9251 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String col = reader.readLine();
        String row = reader.readLine();
        int[][] dp = new int[row.length() + 1][col.length() + 1];
        for (int i = 1; i <= row.length(); i++) {
            for (int j = 1; j <= col.length(); j++) {
                if (row.charAt(i - 1) == col.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[row.length()][col.length()]);
    }

}
