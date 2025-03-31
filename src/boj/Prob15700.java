package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/15700
public class Prob15700 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] wh = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).sorted().toArray();

        long count = 0;
        while (wh[0] > 1) {
            wh[0] -= 2;
            count += wh[1];
        }
        count += wh[0] * wh[1] / 2;
        System.out.println(count);
    }
}
