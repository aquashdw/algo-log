package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/27110
public class Prob27110 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(i -> Math.min(i, n))
                .sum());
    }
}
