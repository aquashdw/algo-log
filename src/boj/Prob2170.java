package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2170
public class Prob2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int time = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).sum();
        time += 8 * (n - 1);
        System.out.printf("%d %d%n", time / 24, time % 24);
    }
}
