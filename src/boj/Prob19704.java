package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/19704
public class Prob19704 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> xs = new ArrayList<>(n);
        List<Integer> ys = new ArrayList<>(n);
        reader.lines().limit(n).forEach(line -> {
            int[] xy = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            xs.add(xy[0]);
            ys.add(xy[1]);
        });
        xs.sort(Integer::compareTo);
        ys.sort(Integer::compareTo);
        System.out.printf("%d %d%n", xs.get(n / 2), ys.get(n / 2));
    }
}
