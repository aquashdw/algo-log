package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/6749
public class Prob6749 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines().limit(2)
                .mapToInt(Integer::parseInt)
                .reduce(-1, (prev, now) -> {
                    if (prev == -1) return now;
                    return now + now - prev;
                }));
    }
}
