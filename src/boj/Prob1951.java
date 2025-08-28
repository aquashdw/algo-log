package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1951
public class Prob1951 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String printed = reader.readLine();
        long n = Long.parseLong(printed);
        int len = printed.length();
        long answer = 0;
        while (n > 0) {
            answer += -((long) Math.pow(10, len - 1) - 1 - n) * len;
            answer %= 1234567;
            n = (long) Math.pow(10, len - 1) - 1;
            len--;
        }
        System.out.println(answer);
    }
}

