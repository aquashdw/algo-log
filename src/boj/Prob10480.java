package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10480
public class Prob10480 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).mapToInt(Integer::parseInt).forEach(i -> {
            if (i % 2 == 0) {
                answer.append(String.format("%d is even\n", i));
            } else {
                answer.append(String.format("%d is odd\n", i));
            }
        });
        System.out.print(answer);
    }
}
