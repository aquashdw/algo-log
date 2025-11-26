package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/26056
public class Prob26056 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] st = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();

        System.out.println(sum(st[1]) - sum(st[0] - 1));
    }

    private static long sum(long n) {
        long total = 0;
        for (long i = 1, j; i <= n; i = j + 1) {
            j = n / (n / i);
            if ((j - i + 1) % 2 == 0) continue;
            if (i % 2 == 0) total += n / i;
            else total -= n / i;
        }
        return total;
    }
}
