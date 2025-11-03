package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/23779
public class Prob23779 {
    private static int[] primes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int silverStar = Integer.parseInt(reader.readLine());
        sieve(silverStar);
        long[] dp = new long[primes.length];
        dp[0] = 1;
        for (int i = 0; i < primes.length; i++) {
            int next = i + 1;
            while (next < primes.length && primes[next] - primes[i] <= 14) {
                dp[next] += dp[i];
                next++;
            }
        }
        System.out.println(dp[primes.length - 1]);
    }

    public static void sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        primes = IntStream.range(0, n + 1).filter(i -> isPrime[i]).toArray();
    }
}
