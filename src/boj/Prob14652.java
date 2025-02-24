package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14652
public class Prob14652 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] seatInfo = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int number = seatInfo[2];
        int n = number / seatInfo[1];
        int m = number % seatInfo[1];
        System.out.printf("%d %d%n", n, m);
    }
}
