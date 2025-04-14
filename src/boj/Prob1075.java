package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1075
public class Prob1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int dividend = Integer.parseInt(reader.readLine());
        int divisor = Integer.parseInt(reader.readLine());

        int reset = dividend / divisor * divisor;
        int h = dividend / 100;
        while (reset / 100 != h) {
            reset += divisor;
        }
        while ((reset - divisor) / 100 == h) {
            reset -= divisor;
        }
        System.out.printf("%02d%n", reset % 100);
    }
}
