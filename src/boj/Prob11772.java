package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.LongStream;

// https://www.acmicpc.net/problem/11772
public class Prob11772 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(reader.lines().limit(n).mapToLong(line -> {
            int exp = line.charAt(line.length() - 1) - '0';
            long base = Long.parseLong(line) / 10;
            return LongStream.range(0, exp).reduce(1, (product, ignore) -> product * base);
        }).sum());
    }
}
