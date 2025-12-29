package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/3053
public class Prob3053 {
    private static final double pi = Math.PI;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int radius = Integer.parseInt(reader.readLine());
        System.out.println(radius * radius * pi);
        int dblRad = radius * 2;
        System.out.println(dblRad * dblRad / 2);
    }
}
