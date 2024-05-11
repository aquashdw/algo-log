package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1541
public class Prob1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sumStrings = reader.readLine().split("-");
        int[] sums = new int[sumStrings.length];
        for (int i = 0; i < sumStrings.length; i++) {
            String sumStr = sumStrings[i];
            sums[i] = Arrays.stream(sumStr.split("\\+"))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        int min = sums[0];
        if (sums.length != 1) for (int i = 1; i < sums.length; i++) {
            min -= sums[i];
        }
        System.out.println(min);
    }
}

