package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/4395
public class Prob4395 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .mapToInt(points -> points[1] - points[0])
                .forEach(dist -> {
                    int base = 1;
                    while (base * base < dist) base++;
                    if (dist < (base * base) - base + 1) answer.append(2 * base - 2).append('\n');
                    else answer.append(2 * base - 1).append('\n');
                });
        System.out.print(answer);
    }
}
