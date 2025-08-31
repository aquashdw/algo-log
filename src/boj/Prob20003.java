package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/20003
public class Prob20003 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] dividends = new long[n];
        long[] divisors = new long[n];
        for (int i = 0; i < n; i++) {
            long[] num = Arrays.stream(reader.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            long gcd = gcd(num[0], num[1]);
            dividends[i] = num[0] / gcd;
            divisors[i] = num[1] / gcd;
        }

        long newUnitDivisor = divisors[0];
        for (int i = 1; i < n; i++) {
            long temp = gcd(newUnitDivisor, divisors[i]);
            newUnitDivisor = newUnitDivisor * divisors[i] / temp;
        }

        for (int i = 0; i < n; i++) {
            dividends[i] *= newUnitDivisor / divisors[i];
        }

        long newUnitDividend = dividends[0];
        for (int i = 1; i < n; i++) {
            newUnitDividend = gcd(newUnitDividend, dividends[i]);
        }

        long gcd = gcd(newUnitDividend, newUnitDivisor);
        newUnitDividend /= gcd;
        newUnitDivisor /= gcd;

        System.out.printf("%d %d%n", newUnitDividend, newUnitDivisor);
    }

    private static long gcd(long x, long y) {
        while (y > 0) {
            long temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
