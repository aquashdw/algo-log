package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/15963
public class Prob15963 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Arrays.stream(reader.readLine().split(" "))
                .reduce(null, (prev, now) -> {
                    if (prev == null) return now;
                    if (prev.equals(now)) return "1";
                    return "0";
                }));
    }
}
