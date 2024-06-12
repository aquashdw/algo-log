package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1010
public class Prob1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests)
                .forEach(line -> {
                    int[] lr = Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    answer.append(solve(lr[0], lr[1])).append('\n');
                });
        System.out.print(answer);
    }

    private static long solve(int l, int r) {
        if (l == 0 || r == 0) return 0;
        long result = 1;
        for (int i = 0; i < l; i++) {
            result *= (r - i);
            result /= (i + 1);
        }
        return result;
    }
}
