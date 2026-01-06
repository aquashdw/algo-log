package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/3276
public class Prob3276 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int rows = 1;
        int cols = 1;
        while (rows * cols < n) {
            if (rows > cols) cols++;
            else rows++;
        }
        System.out.printf("%d %d%n", rows, cols);
    }
}
