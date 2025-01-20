package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/15727
public class Prob15727 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int dist = Integer.parseInt(reader.readLine());
        System.out.println(dist / 5 + (dist % 5 == 0 ? 0 : 1));
    }
}
