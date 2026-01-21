package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/3135
public class Prob3135 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ab = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int start = ab[0];
        int end = ab[1];
        int minClicks = Math.abs(end - start);

        int n = Integer.parseInt(reader.readLine());
        minClicks = Math.min(minClicks, reader.lines().limit(n)
                .mapToInt(Integer::parseInt)
                .map(fav -> Math.abs(end - fav) + 1)
                .min().orElse(0));

        System.out.println(minClicks);
    }

}
