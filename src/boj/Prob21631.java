package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/21631
public class Prob21631 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] bw = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
        System.out.println(Math.min(bw[0] + 1, bw[1]));
    }
}
