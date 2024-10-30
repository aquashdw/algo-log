package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/13212
public class Prob13212 {
    private static boolean[] isPrime;
    private static List<Long> primes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = nk[0];
        int k = nk[1];
        isPrime = new boolean[700005];
        Arrays.fill(isPrime, true);
        primes = new ArrayList<>();
        sieve();

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            char now = input.charAt(0);
            int same = 1;
            int j = 1;
            while (j < input.length()) {
                if (now == input.charAt(j)) same++;
                else {
                    now = input.charAt(j);
                    same = 1;
                }
                if (same > 3) break;
                j++;
            }
            if (same > 3) {
                answer.append("NO").append('\n');
                continue;
            }

            long number = Long.parseLong(input);
            if (number <= k) {
                answer.append("NO").append('\n');
                continue;
            }
            long ceil = (long) Math.sqrt(number + 1);
            ceil = ceil > k ? k : ceil;
            boolean hasFactor = false;
            for (long prime : primes) {
                if (prime > ceil) break;
                if (number % prime == 0) {
                    hasFactor = true;
                    break;
                }
            }
            if (hasFactor) answer.append("NO").append('\n');
            else answer.append("YES").append('\n');
        }

        System.out.print(answer);
    }

    private static void sieve() {
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (long j = (long) i * i; j < isPrime.length; j += i) {
                    isPrime[(int) j] = false;
                }
                primes.add((long) i);
            }
        }
    }
}
/*
4 2
1223344551
1333555777
111
122221
 */
