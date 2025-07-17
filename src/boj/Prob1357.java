package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1357
public class Prob1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int reversedSum = Arrays.stream(reader.readLine().split(" "))
                .map(token -> (new StringBuilder(token).reverse()).toString())
                .mapToInt(Integer::parseInt)
                .sum();

        String revered = (new StringBuilder().append(reversedSum).reverse()).toString();
        System.out.println(Integer.parseInt(revered));
    }
}
