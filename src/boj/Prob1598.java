package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1598
public class Prob1598 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] xy = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(i -> Integer.parseInt(i) - 1).toArray();

        System.out.println(Math.abs(xy[0] / 4 - xy[1] / 4 )+ Math.abs(xy[0] % 4 - xy[1] % 4));
    }
}
