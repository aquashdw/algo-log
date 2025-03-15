package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2721
public class Prob2721 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests)
                .mapToInt(Integer::parseInt)
                .forEach(test -> {
                    long weightedSum = 0;
                    for (int i = 1; i < test + 1; i++) {
                        weightedSum += i * ((long) (i + 1) * (i + 2) / 2);
                    }
                    answer.append(weightedSum).append('\n');
                });
        System.out.print(answer);
    }
}
