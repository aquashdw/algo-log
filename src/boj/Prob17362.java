package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/17362
public class Prob17362 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        n -= 1;
        n %= 8;
        if (n < 4) {
            System.out.println(n + 1);
        } else System.out.println(5 - (n - 4));
    }
}
