package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/1812
public class Prob1812 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] sums = reader.lines().limit(n)
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] candies = new int[n];
        candies[0] = IntStream.range(1, n)
                .reduce(sums[0], (sum, i) -> sum + (i % 2 == 0 ? sums[i] : -sums[i]))
                / 2;
        for (int i = 0; i < n - 1; i++) {
            candies[i + 1] = sums[i] - candies[i];
        }
        StringBuilder answer = new StringBuilder();
        Arrays.stream(candies).forEach(candy -> answer.append(candy).append('\n'));
        System.out.print(answer);
    }
}
