package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/33612
public class Prob33612 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int months = n * 7;
        int years = months / 12 + 2024;
        months %= 12;
        months += 1;
        System.out.printf("%d %d%n", years, months);
    }
}
