package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/27323
public class Prob27323 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines().limit(2)
                .mapToInt(Integer::parseInt)
                .reduce(1, (prev, next) -> prev * next));
    }
}
