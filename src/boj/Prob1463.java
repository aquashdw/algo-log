package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1463
public class Prob1463 {

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if (n == 1) System.out.println(0);
        else if (n < 4) System.out.println(1);
        else {
            int[] dp = new int[n + 1];
            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 1;
            for (int i = 4; i < n + 1; i++) {
                int min = dp[i - 1] + 1;
                if (i % 2 == 0)
                    min = Math.min(dp[i / 2] + 1, min);
                if (i % 3 == 0)
                    min = Math.min(dp[i / 3] + 1, min);
                dp[i] = min;
            }
            System.out.println(dp[n]);
        }
    }
}
