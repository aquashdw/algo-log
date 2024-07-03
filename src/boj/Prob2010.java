package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2010
public class Prob2010 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int holes = reader.lines().limit(count).mapToInt(Integer::parseInt).sum();
        System.out.println(holes - count + 1);
    }
}
