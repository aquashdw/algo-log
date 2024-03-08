package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1654
public class Prob1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] lineInfo = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] lines = reader.lines()
                .limit(lineInfo[0])
                .mapToInt(Integer::parseInt)
                .toArray();

        long max = Arrays.stream(lines)
                .max().orElseThrow();
        long min = 1;
        while (min <= max) {
            long half = (max + min) / 2;
            long count = 0;

            for (int i = 0; i < lineInfo[0]; i++)
                count += lines[i] / half;

            if (count < lineInfo[1])
                max = half - 1;
            else
                min = half + 1;
        }

        System.out.println(max);
    }
}
