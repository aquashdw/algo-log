package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// https://www.acmicpc.net/problem/18110
public class Prob18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long skip = Math.round((double) n * 15 / 100);
        System.out.println(Math.round(reader.lines().limit(n)
                .mapToInt(Integer::parseInt)
                .sorted()
                .skip(skip)
                .limit(n - 2 * skip)
                .average()
                .orElse(0.0)));
    }
}
