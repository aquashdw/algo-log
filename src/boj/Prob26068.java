package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/26068
public class Prob26068 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(reader.lines().limit(n).map(line -> line.split("-")[1])
                .mapToInt(Integer::parseInt)
                .filter(i -> i <= 90)
                .count());
    }
}
