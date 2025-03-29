package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5565
public class Prob5565 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(reader.readLine());
        int remains = total - reader.lines().limit(9).mapToInt(Integer::parseInt).sum();
        System.out.println(remains);
    }
}
