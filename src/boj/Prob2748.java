package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2748
public class Prob2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] fibo = new long[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        System.out.print(fibo[n]);
    }
}
