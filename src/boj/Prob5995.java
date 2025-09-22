package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5995
public class Prob5995 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] hn = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int ceil = hn[0] + 1;
        int[] dp = new int[ceil];
        int[] hays = reader.lines().limit(hn[1]).mapToInt(Integer::parseInt).sorted().toArray();
        for (int w = hays[0]; w < ceil; w++) {
            dp[w] = hays[0];
        }
        for (int i = 1; i < hn[1]; i++) {
            for (int j = ceil - 1; j >= hays[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - hays[i]] + hays[i]);
            }
        }
        System.out.println(dp[ceil - 1]);
    }
}
