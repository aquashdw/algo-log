package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/25991
public class Prob25991 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        double cube = Arrays.stream(reader.readLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .map(side -> side * side * side)
                .sum();
        System.out.println(Math.cbrt(cube));
    }
}
