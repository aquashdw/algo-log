package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/14065
public class Prob14065 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double mpg = Double.parseDouble(reader.readLine());
        double kpl = mpg * 1609.344 / 3.785411784 / 1000;
        System.out.println(100 / kpl);
    }
}
