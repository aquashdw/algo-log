package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/15964
public class Prob15964 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .reduce(-1, (prev, next) -> {
                    if (prev < 0) return next;
                    return (prev + next) * (prev - next);
                }));
    }
}
