package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// https://www.acmicpc.net/problem/1789
public class Prob1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(reader.readLine());
        long sum = 0;
        int i = 1;
        for (; sum + i <= N; i++) {
            sum += i;
        }
        System.out.println(i - 1);
    }
}
