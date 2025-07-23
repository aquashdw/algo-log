package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/20170
public class Prob20170 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] playerA = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] playerB = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int win = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (playerA[i] > playerB[j]) win++;
            }
        }

        int gcd = gcd(win, 36);
        System.out.printf("%d/%d%n", win / gcd, 36 / gcd);
    }

    private static int gcd(int x, int y) {
        while (y > 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
