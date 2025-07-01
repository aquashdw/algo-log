package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/23825
public class Prob23825 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(i -> i / 2)
                .min()
                .ifPresent(System.out::println);
    }
}
