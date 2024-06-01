package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2558
public class Prob2558 {
    public static void main(String[] args) throws IOException {
        System.out.println(new BufferedReader(new InputStreamReader(System.in)).lines().limit(2)
                .mapToInt(Integer::parseInt)
                .sum());
    }

}
