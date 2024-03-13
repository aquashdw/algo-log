package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/4153
public class Prob4153 {
    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        new BufferedReader(new InputStreamReader(System.in)).lines()
                .forEach(line -> {
                    if (!line.equals("0 0 0")) {
                        int[] edges = Arrays.stream(line.split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                        int max = Arrays.stream(edges).max()
                                .orElseThrow();
                        int others = Arrays.stream(edges)
                                .filter(i -> i != max)
                                .reduce(0, (b, i) -> b + i * i);
                        answer.append(max * max == others ? "right\n" : "wrong\n");
                    }
                });
        System.out.print(answer);
    }
}
