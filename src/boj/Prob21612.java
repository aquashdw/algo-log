package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/21612
public class Prob21612 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int boil = Integer.parseInt(reader.readLine());
        int pressure = 5 * boil - 400;
        System.out.printf("%d%n%d%n", pressure, Integer.compare(100, boil));
    }
}
