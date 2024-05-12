package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/7891
public class Prob7891 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(n)
                .forEach(line -> answer.append(Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .sum())
                        .append('\n'));
        System.out.print(answer);
    }
}

