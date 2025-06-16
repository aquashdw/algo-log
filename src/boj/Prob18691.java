package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/18691
public class Prob18691 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> {
            int[] info = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int units = info[0] * 2 - 1;
            int required = Math.max(0, info[2] - info[1]);
            answer.append(units * required).append('\n');
        });
        System.out.print(answer);
    }
}
