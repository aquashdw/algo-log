package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/6064
public class Prob6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests)
                .forEach(line -> {
                    int[] input = Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    answer.append(solve(input[0], input[1], input[2], input[3])).append('\n');
                });
        System.out.println(answer);
    }

    private static int solve(int m, int n, int x, int y) {
        if (x == 1 && y == 1) return 1;
        int i = x;
        if (i % n == 0) i = n;
        else if (i > n) i %= n;
        int count = x;
        while (i != y) {
            if (count > m * n) return -1;
            count += m;
            i += m;
            if (i % n == 0) i = n;
            else if (i > n) i %= n;
        }
        return count;
    }
}
