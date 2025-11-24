package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/27694
public class Prob27694 {
    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());

        int[] dpUp = new int[100001];
        dpUp[0] = 1;
        for (int i = 1; i < 100001; i++) {
            for (int j = 1; j < 3; j++) {
                if (i - j < 0) break;
                dpUp[i] = (dpUp[i] + dpUp[i - j]) % MOD;
            }
        }
        int[] dpDown = new int[100001];
        dpDown[0] = 1;
        for (int i = 1; i < 100001; i++) {
            for (int j = 1; j < 5; j++) {
                if (i - j < 0) break;
                dpDown[i] = (dpDown[i] + dpDown[i - j]) % MOD;
            }
        }

        for (int test = 0; test < tests; test++) {
            reader.readLine();
            int n = Integer.parseInt(reader.readLine());
            long up = dpUp[n];
            long down = dpDown[n];
            System.out.println((up * down) % MOD);
        }
    }
}
