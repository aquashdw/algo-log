package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10039
public class Prob10039 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.lines().limit(5)
                .mapToInt(Integer::parseInt)
                .map(i -> Math.max(i, 40))
                .average().ifPresent(d -> System.out.println((int) d));
    }
}
