package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/15680
public class Prob15680 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.lines().limit(1).mapToInt(Integer::parseInt)
                .mapToObj(i -> i == 0 ? "YONSEI" : "Leading the Way to the Future")
                .forEach(System.out::println);
    }
}
