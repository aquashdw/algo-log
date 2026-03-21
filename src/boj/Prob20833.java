package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/20833
public class Prob20833 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int total = 0;
        for (int i = 1; i < n + 1; i++) {
            total += i * i * i;
        }
        System.out.println(total);
    }
}
