package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/34543
public class Prob34543 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int scores = n * 10;
        if (n >= 3) scores += 20;
        if (n == 5) scores += 50;
        int steps = Integer.parseInt(reader.readLine());
        if (steps > 1000) scores -= 15;
        System.out.println(Math.max(0, scores));
    }
}
