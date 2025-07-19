package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/25600
public class Prob25600 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        reader.lines().limit(n).mapToInt(line -> {
            int[] scores = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int a = scores[0];
            int dg = scores[1] + scores[2];
            int score = a * dg;
            if (a == dg) score *= 2;
            return score;
        }).max().ifPresentOrElse(System.out::println, () -> System.out.println(0));
    }
}

