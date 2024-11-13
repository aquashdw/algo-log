package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/14645
public class Prob14645 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputLines = Integer.parseInt(reader.readLine().split(" ")[0]);
        reader.lines().limit(inputLines).forEach(line -> {});
        System.out.println("비와이");
    }
}
