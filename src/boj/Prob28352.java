package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/28352
public class Prob28352 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        n -= 10;
        int fact = 1;
        for (int i = 0; i < n; i++) {
            fact *= i + 11;
        }
        System.out.println(fact * 6);
    }
}
