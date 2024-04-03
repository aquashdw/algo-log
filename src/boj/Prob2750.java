package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2750
public class Prob2750 {
    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .skip(1)
                .mapToInt(Integer::parseInt)
                .sorted()
                .forEach(l -> answer.append(l).append('\n'));
        System.out.print(answer);
    }
}
