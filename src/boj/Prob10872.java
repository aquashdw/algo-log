package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10872
public class Prob10872 {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int fact = 1;
        for (int i = 1; i < n + 1; i++) {
            fact *= i;
        }
        System.out.println(fact);
    }
}
