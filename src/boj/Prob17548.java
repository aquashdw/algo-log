package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/17548
public class Prob17548 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String hey = reader.readLine();
        int es = hey.length() - 2;
        String answer = 'h' +
                "e".repeat(es * 2) +
                'y';
        System.out.println(answer);
    }
}
