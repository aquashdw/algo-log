package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/14556
public class Prob14556 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        long result = 1;
        for (long i = 1; i < n; i++) {
            result *= (2 * i + 1);
            result %= 1000000009;
        }
        System.out.println(result);
    }
}
