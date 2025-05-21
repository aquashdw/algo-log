package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1094
public class Prob1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int bit = 1;
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if ((bit & x) > 0) count++;
            bit <<= 1;
        }
        System.out.println(count);
    }
}


/*
100000
 */