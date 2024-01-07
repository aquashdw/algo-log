package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2444
public class Prob2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n * 2 - 1; i++) {
            if (i < n) {
                for (int j = 0; j < n - i - 1; j++) {
                    System.out.print(' ');
                }
                for (int j = 0; j < 2 * i + 1; j++) {
                    System.out.print('*');
                }
                System.out.println();
            }
            else {
                for (int j = 0; j < i - n + 1; j++) {
                    System.out.print(' ');
                }
                for (int j = 0; j < 4 * n - 2 * i - 3; j++) {
                    System.out.print('*');
                }
                System.out.println();
            }
        }
    }
}
