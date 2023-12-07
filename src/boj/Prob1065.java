package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// https://www.acmicpc.net/problem/1065
public class Prob1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            if (i < 100) count++;
            else if (match(i)) count++;
        }

        System.out.println(count);
    }

    public static boolean match(int n) {
        if (n > 999) return false;
        int o = n % 10;
        n /= 10;
        int t = n % 10;
        n /= 10;
        int h = n % 10;
        return o - t == t - h;
    }
}
