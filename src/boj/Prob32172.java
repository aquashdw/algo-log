package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://www.acmicpc.net/problem/32172
public class Prob32172 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Set<Integer> found = new HashSet<>();
        found.add(0);
        int[] numbers = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int ai = numbers[i - 1] - i;
            if (ai < 0 || found.contains(ai)) {
                ai += i * 2;
            }
            numbers[i] = ai;
            found.add(numbers[i]);
        }
        System.out.println(numbers[n]);
    }
}
