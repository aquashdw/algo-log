package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/4299
public class Prob4299 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ab = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (ab[0] < ab[1]) {
            System.out.println(-1);
            return;
        }

        int doubleA = ab[0] + ab[1];
        if (doubleA % 2 != 0) {
            System.out.println(-1);
            return;
        }
        int doubleB = Math.abs(ab[0] - ab[1]);
        if (doubleB % 2 != 0) {
            System.out.println(-1);
            return;
        }

        System.out.printf("%d %d%n", Math.max(doubleA / 2, doubleB / 2), Math.min(doubleA / 2, doubleB / 2));
    }
}
