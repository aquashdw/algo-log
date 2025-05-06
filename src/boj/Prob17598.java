package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/17598
public class Prob17598 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] votes = new int[2];
        reader.lines().limit(9).forEach(line -> {
            if (line.equals("Tiger")) votes[0] += 1;
            else votes[1] += 1;
        });
        System.out.println(votes[0] > votes[1] ? "Tiger" : "Lion");
    }
}
