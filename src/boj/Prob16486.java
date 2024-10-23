package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/16486
public class Prob16486 {
    private static final double PI = 3.141592;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines().limit(2).mapToDouble(Double::parseDouble)
                .reduce(0, (perimeter, length) -> perimeter + length * 2 * (perimeter == 0 ? 1 : PI)));
    }
}
