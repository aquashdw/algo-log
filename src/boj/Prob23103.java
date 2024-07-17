package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/23103
public class Prob23103 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] coords = new int[n][];
        IntStream.range(0, n).forEach(i -> {
            try {
                coords[i] = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        int dist = 0;
        for (int i = 0; i < n - 1; i++) {
            dist += Math.abs(coords[i][0] - coords[i + 1][0]);
            dist += Math.abs(coords[i][1] - coords[i + 1][1]);
        }
        System.out.println(dist);
    }
}
