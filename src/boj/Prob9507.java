package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/9507
public class Prob9507 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        int[] cases = reader.lines().limit(tests)
                .mapToInt(Integer::parseInt)
                .toArray();
        int max = Arrays.stream(cases).max().orElseThrow();
        long[] fibo = new long[max + 1];
        for (int i = 0; i < max + 1; i++) {
            if (i < 2) fibo[i] = 1;
            else if (i == 2) fibo[i] = 2;
            else if (i == 3) fibo[i] = 4;
            else fibo[i] = fibo[i - 1] + fibo[i - 2] + fibo[i - 3] + fibo[i - 4];
        }
        StringBuilder answer = new StringBuilder();
        Arrays.stream(cases).forEach(i -> answer.append(fibo[i]).append('\n'));
        System.out.print(answer);
    }
}
