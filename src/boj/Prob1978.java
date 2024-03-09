package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1978
public class Prob1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        System.out.println(Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .filter(Prob1978::isPrime)
                .count());
    }

    private static boolean isPrime(int number) {
        if (number == 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
