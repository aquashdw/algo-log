package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://www.acmicpc.net/problem/3009
public class Prob3009 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] points = reader.lines().limit(3)
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);
        Set<Integer> xs = new HashSet<>();
        Set<Integer> ys = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            if (xs.contains(points[i][0])) xs.remove(points[i][0]);
            else xs.add(points[i][0]);
            if (ys.contains(points[i][1])) ys.remove(points[i][1]);
            else ys.add(points[i][1]);
        }
        System.out.printf("%d %d%n", xs.stream().findFirst().get(), ys.stream().findFirst().get());
    }
}
