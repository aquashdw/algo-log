package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/15080
public class Prob15080 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] start = Arrays.stream(reader.readLine().split(" : "))
                .mapToInt(Integer::parseInt).toArray();
        int[] end = Arrays.stream(reader.readLine().split(" : "))
                .mapToInt(Integer::parseInt).toArray();
        if (end[0] < start[0]) end[0] += 24;

        int diff = 0;
        for (int i = 0; i < 3; i++) {
            diff *= 60;
            if (end[i] < start[i]) {
                diff -= 60;
                end[i] += 60;
            }
            diff += end[i] - start[i];
        }
        System.out.println(diff >= 0 ? diff : diff + 86400);
    }
}
