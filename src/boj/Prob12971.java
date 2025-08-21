package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/12971
public class Prob12971 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] ps = {input[0], input[1], input[2]};
        int[] xs = {input[3], input[4], input[5]};
        int ceil = lcm(lcm(ps[0], ps[1]), ps[2]);
        for (int i = 1; i < ceil; i++) {
            if (i % ps[0] == xs[0] && i % ps[1] == xs[1] && i % ps[2] == xs[2]) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    private static int lcm(int x, int y) {
        return x * y / gcd(x, y);
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
