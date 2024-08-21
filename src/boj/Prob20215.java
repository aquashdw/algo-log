package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/20215
public class Prob20215 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] wh = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rect = wh[0] + wh[1];
        double diag = Math.sqrt(wh[0] * wh[0] + wh[1] * wh[1]);
        System.out.println(Math.abs(diag - rect));
    }
}
