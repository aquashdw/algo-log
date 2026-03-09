package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/1392
public class Prob1392 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nq = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] time = new int[10000];
        int[] secs = reader.lines().limit(nq[0]).mapToInt(Integer::parseInt)
                .toArray();
        int idx = 0;
        int paper = 0;
        for (int sec : secs) {
            for (int i = 0; i < sec; i++) {
                time[idx] = paper;
                idx++;
            }
            paper++;
        }

        System.out.println(reader.lines().limit(nq[1]).mapToInt(Integer::parseInt)
                .mapToObj(i -> String.valueOf(time[i] + 1))
                .collect(Collectors.joining("\n")));
    }
}
