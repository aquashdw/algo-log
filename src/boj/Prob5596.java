package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5596
public class Prob5596 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.lines().limit(2).mapToInt(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .sum())
                .max()
                .ifPresent(System.out::println);
    }
}
