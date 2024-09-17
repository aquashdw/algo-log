package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10772
public class Prob10772 {
    private static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pies = Integer.parseInt(reader.readLine());
        int people = Integer.parseInt(reader.readLine());
        dp = new int[people + 1][pies + 1][pies + 1];
        System.out.println(dp(people, pies, 1));
    }

    private static int dp(int peopleLeft, int piesLeft, int lastPie) {
        if (dp[peopleLeft][piesLeft][lastPie] != 0) return dp[peopleLeft][piesLeft][lastPie];
        if (peopleLeft == 1 || peopleLeft == piesLeft) {
            dp[peopleLeft][piesLeft][lastPie] = 1;
            return dp[peopleLeft][piesLeft][lastPie];
        }
        for (int i = lastPie; i * peopleLeft <= piesLeft; i++) {
            dp[peopleLeft][piesLeft][lastPie] += dp(peopleLeft - 1, piesLeft - i, i);
        }
        return dp[peopleLeft][piesLeft][lastPie];
    }
}
