package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/26561
public class Prob26561 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());

        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> {
            long[] pt = Arrays.stream(line.split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            long population = pt[0];

            population -= pt[1] / 7;
            population += pt[1] / 4;
            answer.append(population).append('\n');
        });
        System.out.print(answer);
    }
}
