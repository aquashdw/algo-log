package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/6856
public class Prob6856 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        if (n + m < 10) {
            System.out.println("There are 0 ways to get the sum 10.");
            return;
        }

        int count = 0;
        for (int i = 1; i < Math.min(n, 9) + 1; i++) {
            if (10 - i <= m) count++;
        }
        if (count == 1) System.out.println("There is 1 way to get the sum 10.");
        else System.out.printf("There are %d ways to get the sum 10.%n", count);
    }
}
