package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/19602
public class Prob19602 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] treats = reader.lines().limit(3).mapToInt(Integer::parseInt).toArray();
        System.out.println(treats[0] + treats[1] * 2 + treats[2] * 3 >= 10 ? "happy" : "sad");
    }
}
