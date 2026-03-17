package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/15001
public class Prob15001 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] stops = reader.lines().limit(n).mapToLong(Long::parseLong).toArray();
        long power = 0;
        for (int i = 1; i < n; i++) {
            power += (stops[i] - stops[i - 1]) * (stops[i] - stops[i - 1]);
        }
        System.out.println(power);
    }
}
