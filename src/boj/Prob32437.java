package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/32437
public class Prob32437 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] dpUp = new int[n + 1];
        int[] dpDown = new int[n + 1];
        dpUp[0] = 1;
        dpDown[0] = 1;
        for (int i = 1; i <= n; i++) {
            int down = dpDown[i - 1] + dpUp[i - 1];
            int up = dpDown[i - 1];
            dpUp[i] = up;
            dpDown[i] = down;
        }
        System.out.println(dpUp[n]);
    }
}
