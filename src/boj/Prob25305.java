package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// https://www.acmicpc.net/problem/25305
public class Prob25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Arrays.stream(reader.readLine().split(" "))
                .skip(1)
                .mapToInt(Integer::parseInt)
                .sum();

        Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .skip(k - 1)
                .limit(1)
                .forEach(System.out::println);
    }
}
