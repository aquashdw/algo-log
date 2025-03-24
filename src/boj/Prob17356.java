package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/17356
public class Prob17356 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int diff = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .reduce(-1, (prev, now) -> {
                    if (prev < 0) return now;
                    return now - prev;
                });
        double m = diff / 400.;
        double prob = 1 / (1 + Math.pow(10, m));
        System.out.println(prob);
    }
}
