package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/13297
public class Prob13297 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        for (int i = 0; i < tests; i++) {
            System.out.println(reader.readLine().length());
        }
    }
}
