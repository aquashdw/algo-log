package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/4714
public class Prob4714 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        reader.lines().takeWhile(line -> !line.equals("-1.0"))
                .mapToDouble(Double::parseDouble)
                .mapToObj(d -> String.format("Objects weighing %.2f on Earth will weigh %.2f on the moon.", d, d * 0.167))
                .forEach(line -> answer.append(line).append('\n'));
        System.out.print(answer);
    }
}
