package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// https://www.acmicpc.net/problem/1929
public class Prob1929 {
    private static int m;
    private static boolean[] isPrime;
    private static List<Integer> primes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mn = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        m = mn[0];
        int n = mn[1];

        if (n < 2) {
            System.out.println(0);
            return;
        }
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        primes = new ArrayList<>();
        sieve();
        StringBuilder answer = new StringBuilder();
        primes.forEach(prime -> answer.append(prime).append('\n'));
        System.out.print(answer);
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

        for (int i = m; i < isPrime.length; i++) {
            if (isPrime[i]) primes.add(i);
        }
    }
}
