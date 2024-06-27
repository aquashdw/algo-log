package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1267
public class Prob1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        int[] seconds = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int yeongsik = Arrays.stream(seconds)
                .map(second -> (second / 30 + 1) * 10)
                .sum();
        int mansik = Arrays.stream(seconds)
                .map(second -> (second / 60 + 1) * 15)
                .sum();

        if (yeongsik < mansik) System.out.printf("Y %d%n", yeongsik);
        else if (yeongsik > mansik) System.out.printf("M %d%n", mansik);
        else System.out.printf("Y M %d%n", yeongsik);
    }

}
