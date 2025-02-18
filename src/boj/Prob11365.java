package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11365
public class Prob11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        reader.lines().takeWhile(line -> !line.equals("END")).map(line -> new StringBuilder(line).reverse().append('\n').toString())
                .forEach(answer::append);
        System.out.print(answer);
    }
}
