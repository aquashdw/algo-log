package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/16293
public class Prob16293 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] hw = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String line;
        int[] xes = {};
        int positions = 0;
        int count = 0;
        for (int i = 0; i < hw[0]; i++) {
            line = reader.readLine();
            String row = line;
            xes = IntStream.range(0, hw[1]).filter(j -> row.charAt(j) != '.').toArray();
            positions += Arrays.stream(xes).sum();
            count += xes.length;
        }
        int left = xes[0];
        int right = xes[xes.length - 1];
        if (2 * positions < 2 * left * count - count) System.out.println("left");
        else if (2 * positions > 2 * right * count + count) System.out.println("right");
        else System.out.println("balanced");
    }
}
