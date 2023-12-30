package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/1644
public class Prob1644 {
    private static boolean[] isPrime;
    private static List<Integer> primes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        if (n < 2) {
            System.out.println(0);
            return;
        }
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        primes = new ArrayList<>();
        sieve();

        int front = 0;
        int back = 1;
        int sum = primes.get(front);
        int count = 0;
        while (true) {
            if (sum < n) {
                if (back >= primes.size()) break;
                sum += primes.get(back);
                back++;
            }
            else if (sum > n) {
                sum -= primes.get(front);
                front++;
            }
            else {
                count++;
                sum -= primes.get(front);
                front++;
            }
        }
        System.out.println(count);
    }

    public static void sieve() {
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) primes.add(i);
        }
    }
}
