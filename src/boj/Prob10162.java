package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10162
public class Prob10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(reader.readLine());
        int fMinutes = time / 300;
        time %= 300;
        int minutes = time / 60;
        time %= 60;
        int tSeconds = time / 10;
        time %= 10;
        if (time != 0) {
            System.out.println(-1);
            return;
        }

        System.out.printf("%d %d %d%n", fMinutes, minutes, tSeconds);
    }
}
