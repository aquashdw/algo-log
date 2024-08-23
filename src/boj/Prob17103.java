package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/17103
public class Prob17103 {
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        int[] numbers = reader.lines().limit(tests)
                .mapToInt(Integer::parseInt)
                .toArray();
        int max = Arrays.stream(numbers).max().orElseThrow();
        isPrime = new boolean[max + 1];
        for (int i = 0; i < max + 1; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < max + 1; i++) {
            if (!isPrime[i]) continue;
            isPrime[i] = true;
            for (int j = i + i; j < max + 1; j += i) {
                isPrime[j] = false;
            }
        }

        StringBuilder answer = new StringBuilder();
        Arrays.stream(numbers).forEach(number -> {
            int count = 0;
            for (int i = 2; i < number / 2 + 1; i++) {
                if (!isPrime[i]) continue;
                if (!isPrime[number - i]) continue;
                count++;
            }
            answer.append(count).append('\n');
        });
        System.out.print(answer);
    }
}
