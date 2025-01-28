package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/6887
public class Prob6887 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxArea = Integer.parseInt(reader.readLine());
        System.out.printf("The largest square has side length %d.%n", (int) Math.sqrt(maxArea));
    }
}
