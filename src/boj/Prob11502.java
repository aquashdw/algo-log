package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/11502
public class Prob11502 {
    private static boolean[] isPrime;
    private static List<Integer> primes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        int[] numbers = reader.lines().limit(tests).mapToInt(Integer::parseInt).toArray();
        isPrime = new boolean[Arrays.stream(numbers).max().orElse(1000) + 1];
        Arrays.fill(isPrime, true);
        sieve();
        StringBuilder answer = new StringBuilder();
        for (int number : numbers) {
            int[] result = null;
            for (int i = 0; i < primes.size(); i++) {
                for (int j = i; j < primes.size(); j++) {
                    for (int k = j; k < primes.size(); k++) {
                        int sum = primes.get(i) + primes.get(j) + primes.get(k);
                        if (sum == number) {
                            result = new int[]{primes.get(i), primes.get(j), primes.get(k)};
                            break;
                        }
                    }
                    if (result != null) break;
                }
                if (result != null) break;
            }
            if (result != null) {
                List<String> resultStrs = Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.toList());
                answer.append(String.join(" ", resultStrs)).append('\n');
            }
            else answer.append(0).append('\n');
        }
        System.out.print(answer);
    }

    public static void sieve() {
        isPrime[0] = false;
        isPrime[1] = false;
        int count = 0;
        for (int i = 2; i * i <= isPrime.length; i++) {
            if (isPrime[i]) {
                count++;
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        primes = new ArrayList<>(count);
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) primes.add(i);
        }
    }
}
