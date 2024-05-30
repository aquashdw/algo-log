package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

// https://www.acmicpc.net/problem/4470
public class Prob4470 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());
        AtomicInteger i = new AtomicInteger();
        reader.lines().limit(n)
                .forEach(line -> answer.append(i.incrementAndGet()).append(". ").append(line).append('\n'));
        System.out.print(answer);
    }
}
