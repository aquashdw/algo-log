package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/16394
public class Prob16394 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.lines().limit(1)
                .mapToInt(Integer::parseInt)
                .map(i -> i - 1946)
                .forEach(System.out::println);
    }
}
