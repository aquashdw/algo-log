package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/26005
public class Prob26005 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = reader.lines().limit(1).mapToInt(Integer::parseInt).sum();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        n *= n;
        System.out.println(n / 2 + n % 2);
    }
}
