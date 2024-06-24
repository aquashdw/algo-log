package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1085
public class Prob1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] coords = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(Math.min(
                Math.min(Math.abs(coords[0] - coords[2]), Math.abs(coords[1] - coords[3])),
                Math.min(coords[0], coords[1])
        ));

    }

}
