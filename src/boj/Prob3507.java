package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/3507
public class Prob3507 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n > 198) {
            System.out.println(0);
            return;
        }

        int count = 0;
        for (int i = 0; i < n + 1; i++) {
            if (n - i < 100 && i < 100) count++;
        }
        System.out.println(count);
    }
}
