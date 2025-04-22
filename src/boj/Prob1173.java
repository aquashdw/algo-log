package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1173
public class Prob1173 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int floor = info[1];
        int ceiling = info[2];
        int rise = info[3];
        int rest = info[4];
        if (floor + rise > ceiling) {
            System.out.println(-1);
            return;
        }
        int minutes = 0;
        int exercise = 0;
        int rate = floor;
        while (exercise < n) {
            if (rate + rise <= ceiling) {
                exercise++;
                rate += rise;
            } else {
                rate -= rest;
                rate = Math.max(floor, rate);
            }
            minutes++;
        }
        System.out.println(minutes);
    }
}
