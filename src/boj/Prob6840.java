package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/6840
public class Prob6840 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines()
                .limit(3)
                .mapToInt(Integer::parseInt)
                .sorted()
                .skip(1)
                .limit(1)
                .sum());
    }
}
