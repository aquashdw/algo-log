package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/31403
public class Prob31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] abc = reader.lines().limit(3)
                .mapToInt(Integer::parseInt)
                .toArray();
        int cal = abc[0] + abc[1] - abc[2];
        int strCal = Integer.parseInt(String.valueOf(abc[0]) + abc[1])
                - abc[2];
        System.out.printf("%d%n%d%n", cal, strCal);
    }
}

