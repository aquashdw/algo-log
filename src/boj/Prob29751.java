package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/29751
public class Prob29751 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double area = Arrays.stream(reader.readLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .reduce(1, (a, b) -> a * b) * 0.5;

        System.out.printf("%.1f", area);
    }
}
