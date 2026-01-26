package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/3058
public class Prob3058 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> {
            int[] evens = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).filter(i -> i % 2 == 0).toArray();
            int minVal = evens[0];
            int sum = 0;
            for (int even : evens) {
                sum += even;
                minVal = Math.min(minVal, even);
            }
            answer.append(String.format("%d %d%n", sum, minVal));
        });
        System.out.print(answer);
    }

}
