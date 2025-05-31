package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/25625
public class Prob25625 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] xy = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        if (xy[0] <= xy[1]) {
            System.out.println(xy[1] - xy[0]);
        } else {
            System.out.println(xy[0] + xy[1]);
        }
    }
}
