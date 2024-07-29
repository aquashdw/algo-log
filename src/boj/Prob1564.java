package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1564
public class Prob1564 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long result = 1;
        for (int i = 1; i < n + 1; i++) {
            result *= i;
            while (result % 10 == 0) {
                result /= 10;
            }
            result %= 1000000000000L;
        }
        result %= 100000;
        System.out.printf("%05d%n", result);
    }
}
// 390625