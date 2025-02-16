package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/24883
public class Prob24883 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.lines().limit(1).forEach(line -> {
            if (line.equals("N") || line.equals("n")) System.out.println("Naver D2");
            else System.out.println("Naver Whale");
        });
    }
}
