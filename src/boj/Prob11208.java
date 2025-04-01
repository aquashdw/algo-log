package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11208
public class Prob11208 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= Math.sqrt(d); i++) {
            int n = d - i * i;
            if (n % 2 != 0) continue;
            n /= 2;
            if (n % i != 0) continue;
            n /= i;
            System.out.printf("%d %d%n", n, n + i);
            return;
        }
        System.out.println("impossible");
    }
}
