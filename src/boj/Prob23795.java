package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/23795
public class Prob23795 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines().takeWhile(line -> !line.equals("-1"))
                .mapToInt(Integer::parseInt)
                .sum());
    }
}
