package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14440
public class Prob14440 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int x = info[0];
        int y = info[1];
        int a0 = info[2];
        int a1 = info[3];
        int n = info[4];

        if (n == 0) {
            System.out.printf("%02d%n", a0);
            return;
        }
        if (n == 1) {
            System.out.printf("%02d%n", a1);
            return;
        }

        long[][] mul = { {1, 0}, {0, 1} };
        long[][] base = { {x, y}, {1, 0} };
        n--;
        while (n > 0) {
            if (n % 2 == 1) mul = multiply(mul, base);
            base = multiply(base, base);
            n /= 2;
        }

        long answer = (mul[0][0] * a1 + mul[0][1] * a0) % 100;
//        if (answer > 0)
        System.out.printf("%02d%n", answer);
//        else {
//            System.out.printf("-%02d%n", Math.abs(answer));
//        }
    }

    private static long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % 100;
                }
            }
        }
        return res;
    }
}
