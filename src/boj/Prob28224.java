package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/28224
public class Prob28224 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(reader.lines().limit(n)
                .mapToInt(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(0));
    }
}
