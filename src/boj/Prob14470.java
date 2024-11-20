package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/14470
public class Prob14470 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(reader.readLine());
        int goal = Integer.parseInt(reader.readLine());
        int frozenStep = Integer.parseInt(reader.readLine());
        int thawingTime = Integer.parseInt(reader.readLine());
        int normalStep = Integer.parseInt(reader.readLine());
        int time = 0;
        if (start < 0) {
            time += Math.abs(start) * frozenStep;
            start = 0;
        }
        if (start == 0) {
            time += thawingTime;
        }
        time += (goal - start) * normalStep;
        System.out.println(time);
    }
}
