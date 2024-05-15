package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2579
public class Prob2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] stairs = reader.lines().limit(n)
                .mapToInt(Integer::parseInt)
                .toArray();
        // 계단이 한칸이면 해당 계단 점수가 정답
        if (n < 2) {
            System.out.println(stairs[0]);
            return;
        }
        // 계단이 두칸이면 두 칸을 다 걸으면 정답이다.
        else if (n == 2) {
            System.out.println(stairs[0] + stairs[1]);
            return;
        }

        // dp[i][]는 해당 계단에 도착했을 때의 점수를 나타낸다.
        int[][] dp = new int[n][2];

        // dp[i][0]는 i - 1에서 한칸 이동해 도착함에 따른 점수
        // 한칸 오른 뒤 한칸 오르는건 불가하다고 할 때,
        // dp[i][0]은 dp[i - 1][1] + stairs[i - 1]이다. 이전에 두칸으로 도착했어야 하기 때문.
        // 단, 시작점은 계단이 아니기 때문에, dp[1][0]은 stairs[0] + stairs[1] 이다.

        // dp[i][1]은 i에 두칸으로 도착함에 따른 점수
        // dp[i][1]은 (dp[i - 2][0] 과 dp[i - 2][1] 중 최댓값) + stairs[i]이다.
        dp[0][0] = stairs[0];
        dp[1][0] = stairs[0] + stairs[1];
        dp[1][1] = stairs[1];

        for (int i = 2; i < n; i++) {
            dp[i][0] = dp[i - 1][1] + stairs[i];
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stairs[i];
        }

        System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
    }
}

