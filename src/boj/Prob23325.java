package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/23325
public class Prob23325 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line.length() == 1) {
            System.out.println(line.charAt(0) == '+' ? 10 : 1);
            return;
        }
        if (line.length() == 2) {
            System.out.println(11);
            return;
        }
        char[] chars = line.toCharArray();
        int[] dp = new int[line.length()];
        dp[0] = chars[0] == '+' ? 10 : 1;
        dp[1] = dp[0] == 10 && chars[1] == '-' ? 11 : Integer.MIN_VALUE;
        for (int i = 2; i < dp.length; i++) {
            int now = chars[i] == '+' ? 10 : 1;
            if (dp[i - 2] != Integer.MIN_VALUE)
                dp[i] = dp[i - 2] + now * (chars[i - 1] == '+' ? 1 : -1);
            else dp[i] = Integer.MIN_VALUE;

            if (now == 1 && chars[i - 1] == '+' && i > 2 && dp[i - 3] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], dp[i - 3] + 11 * (chars[i - 2] == '+' ? 1 : -1));
            }
        }
        System.out.println(dp[dp.length - 1]);
    }

}
