package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2903
public class Prob2903 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int base = 1;
        int dots = 2;
        for (int i = 0; i < n; i++) {
            dots += base;
            base *= 2;
        }
        System.out.println(dots * dots);
    }
}
